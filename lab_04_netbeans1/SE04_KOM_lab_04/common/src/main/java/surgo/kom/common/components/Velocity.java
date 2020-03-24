/*
 * Created by Samuel Bangslund, Odense SDU Software Engineering 1. semester.
 */

package surgo.kom.common.components;

/**
 *
 * @author Samuel Bangslund
 */
public class Velocity extends GameComponent {
    private float dx;
    private float dy;
    
    public Velocity() {
        this(0, 0);
    }
    
    public Velocity(float dx, float dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public void setDx(float dx) {
        this.dx = dx;
    }

    public void setDy(float dy) {
        this.dy = dy;
    }

    public float getDx() {
        return dx;
    }

    public float getDy() {
        return dy;
    }
}
