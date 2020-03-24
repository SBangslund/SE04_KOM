/*
 * Created by Samuel Bangslund, Odense SDU Software Engineering 1. semester.
 */

package surgo.kom.common.components;

/**
 *
 * @author Samuel Bangslund
 */
public class Rotation extends GameComponent {
    private float radians;
    
    public Rotation(float radians) {
        this.radians = radians;
    }

    public void setRadians(float radians) {
        this.radians = radians;
    }
    
    public float getRadians() {
        return radians;
    }
}
