package surgo.kom.core;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import surgo.kom.core.interfaces.IRenderNodeSystem;
import surgo.kom.common.GameData;
import surgo.kom.common.World;
import surgo.kom.common.contracts.*;
import surgo.kom.common.nodes.INode;

public class Game implements ApplicationListener {

    private static OrthographicCamera cam;
    private ShapeRenderer sr;

    private final GameData gameData = new GameData();
    private World world;

    private List<INodeSystem> nodeSystems = new ArrayList<>();
    private List<INodePlugin> nodePlugins = new ArrayList<>();
    private List<IPostNodeSystem> postSystems = new ArrayList<>();
    private List<IRenderNodeSystem> renderSystems = new ArrayList<>();
    private Lookup lookup = Lookup.getDefault();
    private Lookup.Result<INodePlugin> pluginResults;
    private Lookup.Result<INode> nodeResults;

    @Override
    public void create() {

        gameData.setDisplayWidth(Gdx.graphics.getWidth());
        gameData.setDisplayHeight(Gdx.graphics.getHeight());

        cam = new OrthographicCamera(gameData.getDisplayWidth(), gameData.getDisplayHeight());
        cam.translate(gameData.getDisplayWidth() / 2, gameData.getDisplayHeight() / 2);
        cam.update();

        sr = new ShapeRenderer();

        Gdx.input.setInputProcessor(
                new GameInputProcessor(gameData)
        );
        
        lookup = Lookup.getDefault();

        pluginResults = lookup.lookupResult(INodePlugin.class);
        pluginResults.addLookupListener(lookupListener);
        pluginResults.allItems();
        
        nodeResults = lookup.lookupResult(INode.class);
        nodeResults.addLookupListener(lookupListener);
        nodeResults.allItems();
        
        world = new World((List<INode>) nodeResults.allInstances());

        for (INodePlugin plugin : pluginResults.allInstances()) {
            plugin.start(gameData, world);
            nodePlugins.add(plugin);
        }

    }

    @Override
    public void render() {
        // clear screen to black
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        gameData.setDelta(Gdx.graphics.getDeltaTime());

        update();

        draw();

        post();

        gameData.getKeys().update();
    }

    private void update() {
        getNodeSystems().forEach(e -> e.process(gameData, world));
    }

    private void post() {
        getPostNodeSystems().forEach(e -> e.process(gameData, world));
    }

    private void draw() {
        getRenderNodeSystems().forEach(e -> e.process(gameData, world, sr));
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }

    private Collection<? extends INodeSystem> getNodeSystems() {
        return lookup.lookupAll(INodeSystem.class);
    }

    private Collection<? extends IPostNodeSystem> getPostNodeSystems() {
        return lookup.lookupAll(IPostNodeSystem.class);
    }
    
    private Collection<? extends IRenderNodeSystem> getRenderNodeSystems() {
        return lookup.lookupAll(IRenderNodeSystem.class);
    }

    private final LookupListener lookupListener = new LookupListener() {
        @Override
        public void resultChanged(LookupEvent le) {

            Collection<? extends INodePlugin> updatedPlugins = pluginResults.allInstances();
            Collection<? extends INode> updatedNodes = nodeResults.allInstances();
            
            for (INode updatedNode : updatedNodes) {
                if(!world.getNodeTypes().getNodes().values().contains(updatedNode.getClass())) {
                    world.addNodeType(updatedNode.registerNode());
                }
            }
            
            for (INode updatedNode : updatedNodes) {
                if(!updatedNodes.contains(updatedNode)) {
                    world.removeNodeType(updatedNode.registerNode());
                }
            }
            
            for (INodePlugin plugin : updatedPlugins) {
                // Newly installed modules
                if (!nodePlugins.contains(plugin)) {
                    nodePlugins.add(plugin);
                    plugin.start(gameData, world);
                }
            }

            // Stop and remove module
            for (INodePlugin plugin : nodePlugins) {
                if (!updatedPlugins.contains(plugin)) {
                    nodePlugins.remove(plugin);
                    plugin.stop(gameData, world);
                }
            }
        }
    };
}
