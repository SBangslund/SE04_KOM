package surgo.kom.player;

import surgo.kom.common.components.Player;
import surgo.kom.common.components.Weapon;
import surgo.kom.common.nodes.GameNode;

/**
 *
 * @author Samuel Bangslund
 */
public class PlayerWeaponNode extends GameNode {

    @Override
    public GameNode registerNode() {
        super.registerComponent(Player.class);
        super.registerComponent(Weapon.class);
        return this;
    }
}
