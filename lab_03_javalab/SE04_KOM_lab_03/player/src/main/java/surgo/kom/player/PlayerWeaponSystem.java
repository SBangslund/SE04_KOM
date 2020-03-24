package surgo.kom.player;

import java.util.List;
import surgo.kom.common.GameData;
import surgo.kom.common.GameKeys;
import surgo.kom.common.World;
import surgo.kom.common.components.Weapon;
import surgo.kom.common.contracts.INodeSystem;

/**
 *
 * @author Samuel Bangslund
 */
public class PlayerWeaponSystem implements INodeSystem {

    @Override
    public void process(GameData gamedata, World world) {
        List<PlayerWeaponNode> nodes = world.getNodes(PlayerWeaponNode.class);
        for (PlayerWeaponNode node : nodes) {
            Weapon weapon = node.getComponent(Weapon.class);
            if (gamedata.getKeys().isDown(GameKeys.SPACE) && !weapon.isInCooldown()) {
                weapon.setFiring(true);
                weapon.setCooldown(150);
            }
        }
    }
}
