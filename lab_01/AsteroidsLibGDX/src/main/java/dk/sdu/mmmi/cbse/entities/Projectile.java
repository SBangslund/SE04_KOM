/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.entities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;

/**
 *
 * @author sbang
 */
public class Projectile extends SpaceObject {

    private float maxSpeed;
    private float acceleration;
    private float deceleration;

    public Projectile(float x, float y, float radians) {

        this.x = x;
        this.y = y;

        maxSpeed = 400;
        acceleration = 1000;
        deceleration = 0;
        rotationSpeed = 3;

        shapex = new float[2];
        shapey = new float[2];

        this.radians = radians;
    }

    private void setShape() {
        shapex[0] = x;
        shapey[0] = y;

        shapex[1] = x + MathUtils.cos(radians) * 8;
        shapey[1] = y + MathUtils.sin(radians) * 8;
    }

    public void update(float dt) {

        // accelerating
        dx += MathUtils.cos(radians) * acceleration * dt;
        dy += MathUtils.sin(radians) * acceleration * dt;

        // deceleration
        float vec = (float) Math.sqrt(dx * dx + dy * dy);
        if (vec > maxSpeed) {
            dx = (dx / vec) * maxSpeed;
            dy = (dy / vec) * maxSpeed;
        }

        // set position
        x += dx * dt;
        y += dy * dt;

        // set shape
        setShape();

        // screen wrap
        //wrap();
    }

    public void draw(ShapeRenderer sr) {
        sr.setColor(1, 0, 1, 1);
        sr.begin(ShapeRenderer.ShapeType.Line);

        for (int i = 0, j = shapex.length - 1;
                i < shapex.length;
                j = i++) {
            sr.line(shapex[i], shapey[i], shapex[j], shapey[j]);
        }
        sr.end();

    }
}
