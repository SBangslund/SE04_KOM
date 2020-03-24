/*
 * Created by Samuel Bangslund, Odense SDU Software Engineering 1. semester.
 */

package surgo.kom.common.systems;

import java.util.List;
import surgo.kom.common.GameData;
import surgo.kom.common.World;
import surgo.kom.common.components.CollisionBox;
import surgo.kom.common.components.Position;
import surgo.kom.common.contracts.INodeSystem;
import surgo.kom.common.nodes.CollisionNode;

/**
 *
 * @author Samuel Bangslund
 */
public class CollisionSystem implements INodeSystem {

    @Override
    public void process(GameData gamedata, World world) {
        List<CollisionNode> collisionNodes = world.getNodes(CollisionNode.class);
        for (CollisionNode node1 : collisionNodes) {
            for (CollisionNode node2 : collisionNodes) {
                if(node1.equals(node2)) continue;
                                
                Position pos1 = node1.getComponent(Position.class);
                Position pos2 = node2.getComponent(Position.class);
                CollisionBox col1 = node1.getComponent(CollisionBox.class);
                CollisionBox col2 = node2.getComponent(CollisionBox.class);
                
                if(col1.isInCooldown() || col2.isInCooldown()) continue;
                
                float distance = (float) Math.sqrt(Math.pow(pos1.getX() - pos2.getX(), 2) + Math.pow(pos1.getY() - pos2.getY(), 2));
                
                if(distance <= col1.getRadius() + col2.getRadius()) {
                    col1.setHit(col1.getPriority() >= col2.getPriority());
                    col2.setHit(col2.getPriority() >= col2.getPriority());
                }
            }
        }
    }
}
