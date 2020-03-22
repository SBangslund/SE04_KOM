package surgo.kom.enemy;

import org.openide.util.lookup.ServiceProvider;
import surgo.kom.common.Entity;
import surgo.kom.common.GameData;
import surgo.kom.common.World;
import surgo.kom.common.components.CollisionBox;
import surgo.kom.common.components.Enemy;
import surgo.kom.common.components.Moving;
import surgo.kom.common.components.Position;
import surgo.kom.common.components.Render;
import surgo.kom.common.components.Rotation;
import surgo.kom.common.components.Velocity;
import surgo.kom.common.components.Weapon;
import surgo.kom.common.components.interfaces.Drawable;
import surgo.kom.common.contracts.INodePlugin;

/**
 *
 * @author Samuel Bangslund
 */
@ServiceProvider(service = INodePlugin.class)
public class EnemyPlugin implements INodePlugin {

    @Override
    public void start(GameData gamedata, World world) {
        Entity enemy = new Entity();
        enemy.add(new Enemy(500));
        enemy.add(new Position(400, 400));
        enemy.add(new Velocity());
        enemy.add(new Moving(1, 30, 100, 20));
        enemy.add(new Weapon(150));
        enemy.add(new CollisionBox(10));
        Rotation rotation = new Rotation((float) Math.PI / 2);
        enemy.add(rotation);
        enemy.add(new Render(new float[4], new float[4], rotation, new Drawable() {
            @Override
            public void draw(float[] shapex, float[] shapey, Rotation rotation) {
                for (int i = 0; i < 4; i++) {
                    shapex[i] = (float) Math.cos((i + 1) * Math.PI / 2 + rotation.getRadians()) * 10;
                    shapey[i] = (float) Math.sin((i + 1) * Math.PI / 2 + rotation.getRadians()) * 10;
                }
            }
        }));
        world.addEntity(enemy);
    }

    @Override
    public void stop(GameData gamedata, World world) {

    }
}
