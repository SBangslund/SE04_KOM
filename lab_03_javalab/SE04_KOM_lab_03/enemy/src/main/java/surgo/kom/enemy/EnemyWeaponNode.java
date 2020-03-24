package surgo.kom.enemy;

import surgo.kom.common.components.Enemy;
import surgo.kom.common.components.Weapon;
import surgo.kom.common.nodes.GameNode;

/**
 *
 * @author Samuel Bangslund
 */
public class EnemyWeaponNode extends GameNode {

    @Override
    public GameNode registerNode() {
        super.registerComponent(Enemy.class);
        super.registerComponent(Weapon.class);
        return this;
    }
}
