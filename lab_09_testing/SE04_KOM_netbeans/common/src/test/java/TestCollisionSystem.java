import java.util.Arrays;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import surgo.kom.common.Entity;
import surgo.kom.common.World;
import surgo.kom.common.components.CollisionBox;
import surgo.kom.common.components.Position;
import surgo.kom.common.nodes.CollisionNode;
import surgo.kom.common.systems.CollisionSystem;

public class TestCollisionSystem {

    private World world;
    private CollisionBox col1, col2;

    @BeforeEach
    public void setup() {
        world = new World(Arrays.asList(new CollisionNode().registerNode()));
    }

    @Test
    public void test_collision_isHit() {
        System.out.println("Testing CollisionSystem.process (isHit)...");

        Entity subject1 = new Entity();
        col1 = new CollisionBox(10);
        subject1.add(new Position(0, 0));
        subject1.add(col1);

        Entity subject2 = new Entity();
        col2 = new CollisionBox(10);
        subject2.add(new Position(10, 2));
        subject2.add(col2);

        world.addEntity(subject1);
        world.addEntity(subject2);

        new CollisionSystem().process(null, world);
        
        Assert.assertEquals(true, col1.isHit());
        Assert.assertEquals(true, col2.isHit());
    }
    
    @Test
    public void test_collision_isNotHit() {
        System.out.println("Testing CollisionSystem.process (isNotHit)...");

        Entity subject1 = new Entity();
        col1 = new CollisionBox(10);
        subject1.add(new Position(0, 0));
        subject1.add(col1);

        Entity subject2 = new Entity();
        col2 = new CollisionBox(10);
        subject2.add(new Position(21, 0));
        subject2.add(col2);

        world.addEntity(subject1);
        world.addEntity(subject2);

        new CollisionSystem().process(null, world);
        
        Assert.assertEquals(false, col1.isHit());
        Assert.assertEquals(false, col2.isHit());
    }
}
