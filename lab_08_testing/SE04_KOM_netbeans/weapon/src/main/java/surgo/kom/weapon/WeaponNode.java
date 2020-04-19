package surgo.kom.weapon;

import org.openide.util.lookup.ServiceProvider;
import surgo.kom.common.components.Position;
import surgo.kom.common.components.Rotation;
import surgo.kom.common.components.Weapon;
import surgo.kom.common.nodes.GameNode;
import surgo.kom.common.nodes.INode;

/**
 *
 * @author Samuel Bangslund
 */
@ServiceProvider(service = INode.class)
public class WeaponNode extends GameNode {

    @Override
    public GameNode registerNode() {
        super.registerComponent(Weapon.class);
        super.registerComponent(Position.class);
        super.registerComponent(Rotation.class);
        return this;
    }
}
