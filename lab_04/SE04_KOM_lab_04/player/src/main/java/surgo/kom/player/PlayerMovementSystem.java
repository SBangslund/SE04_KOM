package surgo.kom.player;

import org.openide.util.lookup.ServiceProvider;
import surgo.kom.common.GameData;
import surgo.kom.common.GameKeys;
import surgo.kom.common.World;
import surgo.kom.common.components.Moving;
import surgo.kom.common.components.Rotation;
import surgo.kom.common.components.Velocity;
import surgo.kom.common.contracts.INodeSystem;

/**
 *
 * @author Samuel Bangslund
 */
@ServiceProvider(service = INodeSystem.class)
public class PlayerMovementSystem implements INodeSystem {
    
    @Override
    public void process(GameData gamedata, World world) {
        for (PlayerMovementNode node : world.getNodes(PlayerMovementNode.class)) {
            Velocity velocity = node.getComponent(Velocity.class);
            Rotation rotation = node.getComponent(Rotation.class);
            Moving moving = node.getComponent(Moving.class);
                        
            if(gamedata.getKeys().isDown(GameKeys.RIGHT)) {
                rotation.setRadians(rotation.getRadians() - moving.getRotationSpeed() * gamedata.getDelta());
            }
            
            if(gamedata.getKeys().isDown(GameKeys.LEFT)) {
                rotation.setRadians(rotation.getRadians() + moving.getRotationSpeed() * gamedata.getDelta());
            }
            
            if(gamedata.getKeys().isDown(GameKeys.UP)) {
                velocity.setDx(velocity.getDx() + (float)Math.cos(rotation.getRadians()) * moving.getAcceleration() * gamedata.getDelta());
                velocity.setDy(velocity.getDy() + (float)Math.sin(rotation.getRadians()) * moving.getAcceleration() * gamedata.getDelta());
            }
        }
    }
}
