package surgo.kom.enemy;

import surgo.kom.common.components.Enemy;
import surgo.kom.common.components.Moving;
import surgo.kom.common.components.Position;
import surgo.kom.common.components.Rotation;
import surgo.kom.common.components.Velocity;
import surgo.kom.common.nodes.GameNode;

/**
 *
 * @author Samuel Bangslund
 */
public class EnemyMovementNode extends GameNode {

    @Override
    public GameNode registerNode() {
        super.registerComponent(Enemy.class);
        super.registerComponent(Position.class);
        super.registerComponent(Velocity.class);
        super.registerComponent(Rotation.class);
        super.registerComponent(Moving.class);
        return this;
    }
}
