/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.asteroid;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sbang
 */
public class AsteroidPlugin implements IGamePluginService {

    private List<Entity> asteroids = new ArrayList<>();

    @Override
    public void start(GameData gameData, World world) {
        for (int i = 0; i < 10; i++) {
            asteroids.add(createAsteroid(gameData));
        }
        asteroids.forEach(e -> world.addEntity(e));
    }

    private Entity createAsteroid(GameData gameData) {
        float x = (float) (gameData.getDisplayWidth() * Math.random());
        float y = (float) (gameData.getDisplayHeight() * Math.random());
        float radians = (float) (2 * 3.1415f * Math.random());

        Entity asteroid = new Asteroid();
        asteroid.add(new MovingPart(0, 500, 80, 3));
        asteroid.add(new PositionPart(x, y, radians));

        return asteroid;
    }

    @Override
    public void stop(GameData gameData, World world) {
        asteroids.forEach(e -> world.removeEntity(e));
    }
}
