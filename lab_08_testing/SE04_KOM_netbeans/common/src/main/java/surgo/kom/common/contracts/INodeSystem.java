/*
 * Created by Samuel Bangslund, Odense SDU Software Engineering 1. semester.
 */
package surgo.kom.common.contracts;

import surgo.kom.common.GameData;
import surgo.kom.common.World;

/**
 *
 * @author sbang
 */
public interface INodeSystem {
    void process(GameData gamedata, World world);
}
