/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.collision;

import dk.sdu.mmmi.cbse.asteroid.Asteroid;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.CollisionPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

/**
 *
 * @author sbang
 */
public class CollisionSystem implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {
        for (Entity firstEntity : world.getEntities()) {
            CollisionPart firstCollision = firstEntity.getPart(CollisionPart.class);
            if(firstCollision != null) {
                PositionPart firstPosition = firstEntity.getPart(PositionPart.class);
                for (Entity secondEntity : world.getEntities()) {
                    CollisionPart secondCollision = secondEntity.getPart(CollisionPart.class);
                    if(secondCollision != null) {
                        PositionPart secondPosition = secondEntity.getPart(PositionPart.class);
                        
                        double dx = firstPosition.getX() - secondPosition.getX();
                        double dy = firstPosition.getY() - secondPosition.getY();
                        double distance = Math.sqrt(dx * dx + dy * dy);
                        
                        if(distance < firstCollision.getRadius() + secondCollision.getRadius()) {
//                            if(firstEntity instanceof Asteroid && secondEntity instanceof Projectile) {
//                                
//                            } 
                        }
                    }
                }
            }
        }
    }
}
