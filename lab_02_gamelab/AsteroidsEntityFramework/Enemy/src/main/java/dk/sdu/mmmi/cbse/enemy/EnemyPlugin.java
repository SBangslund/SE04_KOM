/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.enemy;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

/**
 *
 * @author sbang
 */
public class EnemyPlugin implements IGamePluginService {

    private Entity enemy;
    
    @Override
    public void start(GameData gameData, World world) {
        enemy = createEnemyShip(gameData);
        world.addEntity(enemy);
    }
    
    private Entity createEnemyShip(GameData gameData) {

        float x = (float) (gameData.getDisplayWidth() * Math.random());
        float y = (float) (gameData.getDisplayHeight() * Math.random());
        float radians = 3.1415f / 2;
        
        Entity enemy = new Enemy();
        enemy.add(new MovingPart(10, 100, 200, 5));
        enemy.add(new PositionPart(x, y, radians));
        
        return enemy;
    }

    @Override
    public void stop(GameData gameData, World world) {
        world.removeEntity(enemy);
    }
}
