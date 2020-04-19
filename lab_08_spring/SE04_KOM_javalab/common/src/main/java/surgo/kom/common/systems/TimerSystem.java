/*
 * Created by Samuel Bangslund, Odense SDU Software Engineering 1. semester.
 */

package surgo.kom.common.systems;

import java.util.ArrayList;
import java.util.List;
import surgo.kom.common.Entity;
import surgo.kom.common.GameData;
import surgo.kom.common.World;
import surgo.kom.common.components.Timer;
import surgo.kom.common.contracts.INodeSystem;
import surgo.kom.common.nodes.TimerNode;

/**
 *
 * @author Samuel Bangslund
 */
public class TimerSystem implements INodeSystem {

    @Override
    public void process(GameData gamedata, World world) {
        List<TimerNode> nodes = world.getNodes(TimerNode.class);
        List<Entity> markedForRemoval = new ArrayList<>();
        for (TimerNode node : nodes) {
            Timer timer = node.getComponent(Timer.class);
            if(timer.isExpired()) {
                markedForRemoval.add(node.getParentEntity());
            }
        }
        markedForRemoval.forEach(e -> world.removeEntity(e));
    }
}
