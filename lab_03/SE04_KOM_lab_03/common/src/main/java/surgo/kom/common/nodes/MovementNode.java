/*
 * Created by Samuel Bangslund, Odense SDU Software Engineering 1. semester.
 */

package surgo.kom.common.nodes;

import surgo.kom.common.components.Moving;
import surgo.kom.common.components.Position;
import surgo.kom.common.components.Velocity;

/**
 *
 * @author Samuel Bangslund
 */
public class MovementNode extends GameNode {

    @Override
    public GameNode registerNode() {
        super.registerComponent(Position.class);
        super.registerComponent(Velocity.class);
        super.registerComponent(Moving.class);
        return this;
    }
}
