package surgo.kom.asteroid;

import java.util.Random;
import org.openide.util.lookup.ServiceProvider;
import surgo.kom.common.Entity;
import surgo.kom.common.GameData;
import surgo.kom.common.World;
import surgo.kom.common.components.Asteroid;
import surgo.kom.common.components.CollisionBox;
import surgo.kom.common.components.Moving;
import surgo.kom.common.components.Position;
import surgo.kom.common.components.Render;
import surgo.kom.common.components.Rotation;
import surgo.kom.common.components.Velocity;
import surgo.kom.common.contracts.INodePlugin;

/**
 *
 * @author Samuel Bangslund
 */
@ServiceProvider(service = INodePlugin.class)
public class AsteroidPlugin implements INodePlugin {

    @Override
    public void start(GameData gamedata, World world) {
        Random random = new Random(1234135);
        for (int i = 0; i < 15; i++) {
            Entity asteroid = new Entity();
            Asteroid ast = new Asteroid();
            asteroid.add(ast);
            asteroid.add(new Position((float) Math.random() * gamedata.getDisplayWidth(), (float) Math.random() * gamedata.getDisplayHeight()));
            asteroid.add(new Velocity(random.nextBoolean() ? 1 * (float) Math.random() * 100: - 1 * (float) Math.random() * 100, random.nextBoolean() ? 1 * (float) Math.random() * 100: - 1 * (float) Math.random() * 100));
            asteroid.add(new Moving(0f, 0f, 200, 10f));
            Rotation rotation = new Rotation((float) (Math.PI * 2 * Math.random()));
            asteroid.add(rotation);
            CollisionBox collision = new CollisionBox(10, 0, 1000);
            asteroid.add(collision);
            asteroid.add(new Render(new float[10], new float[10], rotation, (float[] shapex, float[] shapey, Rotation rot) -> {
                for (int j = 0; j < 10; j++) {
                    shapex[j] = (float) Math.cos(2 * Math.PI * j / 10 + rot.getRadians()) * collision.getRadius();
                    shapey[j] = (float) Math.sin(2 * Math.PI * j / 10 + rot.getRadians()) * collision.getRadius();
                }
            }));
            world.addEntity(asteroid);
        }
    }

    @Override
    public void stop(GameData gamedata, World world) {

    }
}
