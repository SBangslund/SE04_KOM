package surgo.kom.common.systems;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import surgo.kom.common.GameData;
import surgo.kom.common.World;
import surgo.kom.common.components.Position;
import surgo.kom.common.components.Render;
import surgo.kom.common.contracts.IRenderNodeSystem;
import surgo.kom.common.nodes.RenderNode;

/**
 *
 * @author Samuel Bangslund
 */
public class RenderSystem implements IRenderNodeSystem {
    
    @Override
    public void process(GameData gamedata, World world, ShapeRenderer sr) {
        for (RenderNode node : world.getNodes(RenderNode.class)) {
            Position position = node.getComponent(Position.class);
            Render render = node.getComponent(Render.class);
                        
            sr.setColor(1, 1, 1, 1);
            sr.begin(ShapeRenderer.ShapeType.Line);
            
            render.getDrawable().draw(render.getShapeX(), render.getShapeY(), render.getRotation());
            float[] shapex = render.getShapeX();
            float[] shapey = render.getShapeY();
            float x = position.getX();
            float y = position.getY();
            
            for (int i = 0, j = shapex.length - 1; i < shapex.length; j = i++) {
                sr.line(x + shapex[i], y + shapey[i], x + shapex[j], y + shapey[j]);
            }
            
            sr.end();
        }
    }
}
