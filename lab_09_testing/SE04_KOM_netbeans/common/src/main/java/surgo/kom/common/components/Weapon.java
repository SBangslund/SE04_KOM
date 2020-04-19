/*
 * Created by Samuel Bangslund, Odense SDU Software Engineering 1. semester.
 */
package surgo.kom.common.components;

/**
 *
 * @author Samuel Bangslund
 */
public class Weapon extends GameComponent {

    private float speed;
    private int cooldown = 0;
    private long initCooldown = 0;
    private boolean firing;

    public Weapon(float speed) {
        this.speed = speed;
    }

    public float getSpeed() {
        return speed;
    }

    public boolean isFiring() {
        return firing;
    }

    public void setFiring(boolean firing) {
        this.firing = firing;
    }

    public void setCooldown(int cooldown) {
        initCooldown = System.currentTimeMillis();
        this.cooldown = cooldown;
    }
    
    public boolean isInCooldown() {
        return System.currentTimeMillis() - initCooldown < cooldown;
    }
}
