package surgo.kom.enemy;

import surgo.kom.common.GameData;
import surgo.kom.common.World;
import surgo.kom.common.components.Enemy;
import surgo.kom.common.components.Moving;
import surgo.kom.common.components.Rotation;
import surgo.kom.common.components.Velocity;
import surgo.kom.common.contracts.INodeSystem;

/**
 *
 * @author Samuel Bangslund
 */
public class EnemyMovementSystem implements INodeSystem {

    @Override
    public void process(GameData gamedata, World world) {
        for (EnemyMovementNode node : world.getNodes(EnemyMovementNode.class)) {
            Velocity velocity = node.getComponent(Velocity.class);
            Rotation rotation = node.getComponent(Rotation.class);
            Moving moving = node.getComponent(Moving.class);
            Enemy enemy = node.getComponent(Enemy.class);
            
            double direction = Math.random();
            
            if(!enemy.isInCooldown()) {
                if(direction <= 0.5) {
                    rotation.setRadians(rotation.getRadians() - moving.getRotationSpeed() * gamedata.getDelta());
                }

                if(direction >= 0.5 && direction < 1) {
                    rotation.setRadians(rotation.getRadians() + moving.getRotationSpeed() * gamedata.getDelta());
                }

                if(direction >= 0.3 && direction <= 0.7) {
                    velocity.setDx(velocity.getDx() + (float)Math.cos(rotation.getRadians()) * moving.getAcceleration());
                    velocity.setDy(velocity.getDy() + (float)Math.sin(rotation.getRadians()) * moving.getAcceleration());
                }
                enemy.startCooldown();
            }
        }
    }
}
