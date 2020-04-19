package surgo.kom.player;

import org.openide.util.lookup.ServiceProvider;
import surgo.kom.common.components.Player;
import surgo.kom.common.components.Weapon;
import surgo.kom.common.nodes.GameNode;
import surgo.kom.common.nodes.INode;

/**
 *
 * @author Samuel Bangslund
 */
@ServiceProvider(service = INode.class)
public class PlayerWeaponNode extends GameNode {

    @Override
    public GameNode registerNode() {
        super.registerComponent(Player.class);
        super.registerComponent(Weapon.class);
        return this;
    }
}
