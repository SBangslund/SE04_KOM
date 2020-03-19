/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.entities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import dk.sdu.mmmi.cbse.main.Game;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sbang
 */
public class Enemy extends SpaceObject {

    private boolean left;
    private boolean right;
    private boolean up;
    private boolean firing;

    private float maxSpeed;
    private float acceleration;
    private float deceleration;

    private List<Projectile> projectiles;

    public Enemy() {

        x = (float) (Game.WIDTH * Math.random());
        y = (float) (Game.HEIGHT * Math.random());

        projectiles = new ArrayList<>();

        maxSpeed = 160;
        acceleration = 80;
        deceleration = 25;

        shapex = new float[4];
        shapey = new float[4];

        radians = 3.1415f / 2;
        rotationSpeed = 3;

    }

    private void setShape() {
        shapex[0] = x + MathUtils.cos(radians) * 8;
        shapey[0] = y + MathUtils.sin(radians) * 8;

        shapex[1] = x + MathUtils.cos(radians - 4 * 3.1415f / 5) * 8;
        shapey[1] = y + MathUtils.sin(radians - 4 * 3.1145f / 5) * 8;

        shapex[2] = x + MathUtils.cos(radians + 3.1415f) * 5;
        shapey[2] = y + MathUtils.sin(radians + 3.1415f) * 5;

        shapex[3] = x + MathUtils.cos(radians + 4 * 3.1415f / 5) * 8;
        shapey[3] = y + MathUtils.sin(radians + 4 * 3.1415f / 5) * 8;
    }

    public void update(float dt) {
        double direction = Math.random();
        left = direction < 0.3;
        right = direction > 0.3 && direction < 0.6;
        up = direction >= 0.6;
        firing = direction < 0.01f;

        // turning
        if (left) {
            radians += rotationSpeed * dt;
        } else if (right) {
            radians -= rotationSpeed * dt;
        }

        // accelerating
        if (up) {
            dx += MathUtils.cos(radians) * acceleration * dt;
            dy += MathUtils.sin(radians) * acceleration * dt;
        }

        // deceleration
        float vec = (float) Math.sqrt(dx * dx + dy * dy);
        if (vec > 0) {
            dx -= (dx / vec) * deceleration * dt;
            dy -= (dy / vec) * deceleration * dt;
        }
        if (vec > maxSpeed) {
            dx = (dx / vec) * maxSpeed;
            dy = (dy / vec) * maxSpeed;
        }

        if (firing) {
            projectiles.add(new Projectile((float) Math.cos(radians) * 5 + x, (float) Math.sin(radians) * 5 + y, radians));
        }

        // set position
        x += dx * dt;
        y += dy * dt;

        projectiles.forEach(e -> e.update(dt));
        
        // set shape
        setShape();

        // screen wrap
        wrap();

    }

    public void draw(ShapeRenderer sr) {

        sr.setColor(1, 1, 0, 1);

        sr.begin(ShapeRenderer.ShapeType.Line);

        for (int i = 0, j = shapex.length - 1;
                i < shapex.length;
                j = i++) {

            sr.line(shapex[i], shapey[i], shapex[j], shapey[j]);

        }

        sr.end();
        
        projectiles.forEach(e -> e.draw(sr));
    }
}
