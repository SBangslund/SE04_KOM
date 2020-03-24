package dk.sdu.mmmi.cbse.asteroid;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

public class AsteroidMovementSystem implements IEntityProcessingService {
    
    @Override
    public void process(GameData gameData, World world) {
        for (Entity asteroid : world.getEntities(Asteroid.class)) {
            PositionPart positionPart = asteroid.getPart(PositionPart.class);
            MovingPart movingPart = asteroid.getPart(MovingPart.class);
            
            movingPart.setDx((float) Math.cos(positionPart.getRadians()) * 100);
            movingPart.setDy((float) Math.sin(positionPart.getRadians()) * 100);
            
            movingPart.process(gameData, asteroid);
            positionPart.process(gameData, asteroid);
            
            updateShape(asteroid);
        }
    }
    
    private void updateShape(Entity entity) {
        float[] shapex = new float[13];
        float[] shapey = new float[13];
        PositionPart positionPart = entity.getPart(PositionPart.class);
        float x = positionPart.getX();
        float y = positionPart.getY();
        entity.setRadius(10);
        
        for (int i = 0; i <= 12; i++) {
            shapex[i] = (float) (Math.cos(i * Math.PI / 6) * entity.getRadius() + x);
            shapey[i] = (float) (Math.sin(i * Math.PI / 6) * entity.getRadius() + y);
        }
        
        entity.setShapeX(shapex);
        entity.setShapeY(shapey);
    }
}
