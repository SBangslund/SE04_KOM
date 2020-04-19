/*
 * Created by Samuel Bangslund, Odense SDU Software Engineering 1. semester.
 */

package surgo.kom.common.components;

import java.util.Date;

/**
 *
 * @author Samuel Bangslund
 */
public class CollisionBox extends GameComponent {
    private float radius;
    private int priority = 0;
    private boolean hit = false;
    
    private long spawnedAtTime;
    private int cooldown = 0;
    private boolean isInCooldown = false;
    
    public CollisionBox(float radius) {
        this.radius = radius;
        this.spawnedAtTime = new Date().getTime();
    }
    
    public CollisionBox(float radius, int priority, int cooldown) {
        this(radius);
        this.priority = priority;
        this.cooldown = cooldown;
    }
    
    public void setHit(boolean hasHit) {
        this.hit = hasHit;
    }
    
    public boolean isHit() {
        return hit;
    }
    
    public float getRadius() {
        return this.radius;
    }

    public int getPriority() {
        return priority;
    }

    public long getSpawnedAtTime() {
        return spawnedAtTime;
    }
    
    public int getCurrentCooldown() {
        return (int)(new Date().getTime() - spawnedAtTime);
    }
    
    public boolean isInCooldown() {
        return (new Date().getTime() - spawnedAtTime) < cooldown;
    }
}
