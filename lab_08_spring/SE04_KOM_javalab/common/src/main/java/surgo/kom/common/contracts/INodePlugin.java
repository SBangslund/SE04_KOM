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
public interface INodePlugin {
    void start(GameData gamedata, World world);
    void stop(GameData gamedata, World world);
}
