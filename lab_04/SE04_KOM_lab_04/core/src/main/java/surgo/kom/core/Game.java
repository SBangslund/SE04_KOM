package surgo.kom.core;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import org.openide.util.Lookup;
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

        Lookup lookup = Lookup.getDefault();
        
        world = new World((Iterator<INode>)lookup.lookupAll(INode.class).iterator());

        for (INodeSystem system : lookup.lookupAll(INodeSystem.class)) {
            nodeSystems.add(system);
        }

        for (INodePlugin plugin : lookup.lookupAll(INodePlugin.class)) {
            nodePlugins.add(plugin);
        }

        for (IPostNodeSystem system : lookup.lookupAll(IPostNodeSystem.class)) {
            postSystems.add(system);
        }

        for (IRenderNodeSystem system : lookup.lookupAll(IRenderNodeSystem.class)) {
            renderSystems.add(system);
        }

        nodePlugins.forEach(e -> e.start(gameData, world));
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
        nodeSystems.forEach(e -> e.process(gameData, world));
    }

    private void post() {
        postSystems.forEach(e -> e.process(gameData, world));
    }

    private void draw() {
        renderSystems.forEach(e -> e.process(gameData, world, sr));
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
}
