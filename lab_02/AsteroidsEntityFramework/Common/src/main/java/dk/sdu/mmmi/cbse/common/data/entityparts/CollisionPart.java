package dk.sdu.mmmi.cbse.common.data.entityparts;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;

public class CollisionPart implements EntityPart {

    private float radius;
    private int priority;

    public CollisionPart(float radius, int priority) {
        this.radius = radius;
        this.priority = priority;
    }

    public float getRadius() {
        return radius;
    }

    public int getPriority() {
        return priority;
    }
    
    @Override
    public void process(GameData gameData, Entity entity) {

    }
}
