/*
 * Created by Samuel Bangslund, Odense SDU Software Engineering 1. semester.
 */

package surgo.kom.common.systems;

import org.openide.util.lookup.ServiceProvider;
import surgo.kom.common.GameData;
import surgo.kom.common.World;
import surgo.kom.common.components.Moving;
import surgo.kom.common.components.Position;
import surgo.kom.common.components.Velocity;
import surgo.kom.common.contracts.INodeSystem;
import surgo.kom.common.nodes.MovementNode;

/**
 *
 * @author Samuel Bangslund
 */
@ServiceProvider(service = INodeSystem.class)
public class MovementSystem implements INodeSystem {

    @Override
    public void process(GameData gamedata, World world) {
        for (MovementNode node : world.getNodes(MovementNode.class)) {
            Position position = node.getComponent(Position.class);
            Velocity velocity = node.getComponent(Velocity.class);
            Moving moving = node.getComponent(Moving.class);
                        
            float x = position.getX();
            float y = position.getY();
            float dx = velocity.getDx();
            float dy = velocity.getDy();
                        
            position.setX(position.getX() + dx * gamedata.getDelta());
            position.setY(position.getY() + dy * gamedata.getDelta());
            
            if(x > gamedata.getDisplayWidth()) {
                position.setX(0);
            } else if(x < 0) {
                position.setX(gamedata.getDisplayWidth());
            }
            
            if(y > gamedata.getDisplayHeight()) {
                position.setY(0);
            } else if(y < 0) {
                position.setY(gamedata.getDisplayHeight());
            }
            
            float vec = (float) Math.sqrt(dx * dx + dy * dy);
            if (vec > 0) {
                dx -= (dx / vec) * moving.getDeceleration() * gamedata.getDelta();
                dy -= (dy / vec) * moving.getDeceleration() * gamedata.getDelta();
            }
            if (vec > moving.getMaxSpeed()) {
                dx = (dx / vec) * moving.getMaxSpeed();
                dy = (dy / vec) * moving.getMaxSpeed();
            }
            
            velocity.setDx(dx);
            velocity.setDy(dy);
        }
    }
}
