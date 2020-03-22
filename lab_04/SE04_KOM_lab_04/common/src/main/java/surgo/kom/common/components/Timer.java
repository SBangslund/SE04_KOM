/*
 * Created by Samuel Bangslund, Odense SDU Software Engineering 1. semester.
 */

package surgo.kom.common.components;

import java.util.Date;

/**
 *
 * @author Samuel Bangslund
 */
public class Timer extends GameComponent {
    private long creationTime;
    private int expirationTime;
    
    public Timer(int time) {
        this.expirationTime = time;
        this.creationTime = new Date().getTime();
    }

    public long getCreationTime() {
        return creationTime;
    }

    public int getExpirationTime() {
        return expirationTime;
    }
    
    public boolean isExpired() {
        return new Date().getTime() - creationTime > expirationTime;
    }
}
