package surgo.kom.enemy;

import surgo.kom.common.GameData;
import surgo.kom.common.World;
import surgo.kom.common.components.Weapon;
import surgo.kom.common.contracts.INodeSystem;

/**
 *
 * @author Samuel Bangslund
 */
public class EnemyWeaponSystem implements INodeSystem {

    @Override
    public void process(GameData gamedata, World world) {
        for (EnemyWeaponNode node : world.getNodes(EnemyWeaponNode.class)) {
            Weapon weapon = node.getComponent(Weapon.class);
            if(Math.random() < 0.1) {
                weapon.setFiring(true);
            }
        }
    }
}
