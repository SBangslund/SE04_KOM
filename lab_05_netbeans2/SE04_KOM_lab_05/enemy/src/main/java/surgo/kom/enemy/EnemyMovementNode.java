package surgo.kom.enemy;

import org.openide.util.lookup.ServiceProvider;
import surgo.kom.common.components.Enemy;
import surgo.kom.common.components.Moving;
import surgo.kom.common.components.Position;
import surgo.kom.common.components.Rotation;
import surgo.kom.common.components.Velocity;
import surgo.kom.common.nodes.GameNode;
import surgo.kom.common.nodes.INode;

/**
 *
 * @author Samuel Bangslund
 */
@ServiceProvider(service = INode.class)
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
