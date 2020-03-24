/*
 * Created by Samuel Bangslund, Odense SDU Software Engineering 1. semester.
 */

package surgo.kom.weapon;

import surgo.kom.common.components.Position;
import surgo.kom.common.components.Rotation;
import surgo.kom.common.components.Weapon;
import surgo.kom.common.nodes.GameNode;

/**
 *
 * @author Samuel Bangslund
 */
public class WeaponNode extends GameNode {

    @Override
    public GameNode registerNode() {
        super.registerComponent(Weapon.class);
        super.registerComponent(Position.class);
        super.registerComponent(Rotation.class);
        return this;
    }
}
