/*
 * Created by Samuel Bangslund, Odense SDU Software Engineering 1. semester.
 */

package surgo.kom.common.nodes;

import surgo.kom.common.components.CollisionBox;
import surgo.kom.common.components.Position;

/**
 *
 * @author Samuel Bangslund
 */
public class CollisionNode extends GameNode {

    @Override
    public GameNode registerNode() {
        super.registerComponent(Position.class);
        super.registerComponent(CollisionBox.class);
        return this;
    }
}
