package surgo.kom.player;

import surgo.kom.common.Entity;
import surgo.kom.common.GameData;
import surgo.kom.common.World;
import surgo.kom.common.components.CollisionBox;
import surgo.kom.common.components.Moving;
import surgo.kom.common.components.Player;
import surgo.kom.common.components.Position;
import surgo.kom.common.components.Render;
import surgo.kom.common.components.Rotation;
import surgo.kom.common.components.Velocity;
import surgo.kom.common.components.Weapon;
import surgo.kom.common.contracts.INodePlugin;

/**
 *
 * @author Samuel Bangslund
 */
public class PlayerPlugin implements INodePlugin {

    @Override
    public void start(GameData gamedata, World world) {
        Entity player = new Entity();
        player.add(new Position(gamedata.getDisplayWidth() / 2, gamedata.getDisplayHeight() / 2));
        player.add(new Velocity(0f, 0f));
        player.add(new CollisionBox(10f));
        player.add(new Moving(50f, 150f, 200f, 6f));
        player.add(new Player());
        player.add(new Weapon(150));
        Rotation rotation = new Rotation((float) Math.PI / 2);
        player.add(rotation);
        player.add(new Render(new float[4], new float[4], rotation, (float[] shapex, float[] shapey, Rotation rot) -> {
            float radians = rot.getRadians();
            shapex[0] = (float) (Math.cos(radians) * 8);
            shapey[0] = (float) (Math.sin(radians) * 8);

            shapex[1] = (float) (Math.cos(radians - 4 * 3.1415f / 5) * 8);
            shapey[1] = (float) (Math.sin(radians - 4 * 3.1145f / 5) * 8);

            shapex[2] = (float) (Math.cos(radians + 3.1415f) * 5);
            shapey[2] = (float) (Math.sin(radians + 3.1415f) * 5);

            shapex[3] = (float) (Math.cos(radians + 4 * 3.1415f / 5) * 8);
            shapey[3] = (float) (Math.sin(radians + 4 * 3.1415f / 5) * 8);
        }));
        world.addEntity(player);
    }

    @Override
    public void stop(GameData gamedata, World world) {
        
    }

}
