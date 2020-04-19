package surgo.kom.enemy;

import org.openide.util.lookup.ServiceProvider;
import surgo.kom.common.components.Enemy;
import surgo.kom.common.components.Weapon;
import surgo.kom.common.nodes.GameNode;
import surgo.kom.common.nodes.INode;

/**
 *
 * @author Samuel Bangslund
 */
@ServiceProvider(service = INode.class)
public class EnemyWeaponNode extends GameNode {

    @Override
    public GameNode registerNode() {
        super.registerComponent(Enemy.class);
        super.registerComponent(Weapon.class);
        return this;
    }
}
