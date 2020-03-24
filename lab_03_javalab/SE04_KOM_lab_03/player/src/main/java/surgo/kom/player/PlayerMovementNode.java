package surgo.kom.player;

import surgo.kom.common.components.Moving;
import surgo.kom.common.components.Player;
import surgo.kom.common.components.Position;
import surgo.kom.common.components.Rotation;
import surgo.kom.common.components.Velocity;
import surgo.kom.common.nodes.GameNode;

/**
 *
 * @author Samuel Bangslund
 */
public class PlayerMovementNode extends GameNode {

    @Override
    public GameNode registerNode() {
        super.registerComponent(Position.class);
        super.registerComponent(Velocity.class);
        super.registerComponent(Rotation.class);
        super.registerComponent(Moving.class);
        super.registerComponent(Player.class);
        return this;
    }
}
