/*
 * Created by Samuel Bangslund, Odense SDU Software Engineering 1. semester.
 */

package surgo.kom.common.components;

import java.util.Date;

/**
 *
 * @author Samuel Bangslund
 */
public class Enemy extends GameComponent {
    private int cooldown;
    private long currentTime;

    public Enemy(int cooldown) {
        this.cooldown = cooldown;
    }
    
    public void startCooldown() {
        currentTime = new Date().getTime();
    }

    public boolean isInCooldown() {
        return new Date().getTime() - currentTime < cooldown;
    }
    
    public float getCooldown() {
        return cooldown;
    }

    public long getCurrentTime() {
        return currentTime;
    }
}
