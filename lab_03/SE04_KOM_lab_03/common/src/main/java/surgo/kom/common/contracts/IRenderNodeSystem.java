package surgo.kom.common.contracts;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import surgo.kom.common.GameData;
import surgo.kom.common.World;

/**
 *
 * @author sbang
 */
public interface IRenderNodeSystem {
    void process(GameData gameData, World world, ShapeRenderer sr);
}
