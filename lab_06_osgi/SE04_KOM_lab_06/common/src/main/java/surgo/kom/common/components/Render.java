/*
 * Created by Samuel Bangslund, Odense SDU Software Engineering 1. semester.
 */

package surgo.kom.common.components;

import surgo.kom.common.components.interfaces.Drawable;

/**
 *
 * @author Samuel Bangslund
 */
public class Render extends GameComponent {
    private float[] shapeX = new float[4];
    private float[] shapeY = new float[4];
    private Rotation rotation;
    private Drawable drawable;
   
    public Render(float[] shapeX, float[] shapeY, Rotation rotation, Drawable drawable) {
        this.shapeX = shapeX;
        this.shapeY = shapeY;
        this.rotation = rotation;
        this.drawable = drawable;
    }

    public void setShapeX(float[] shapeX) {
        this.shapeX = shapeX;
    }

    public void setShapeY(float[] shapeY) {
        this.shapeY = shapeY;
    }

    public float[] getShapeX() {
        return shapeX;
    }

    public float[] getShapeY() {
        return shapeY;
    }
    
    public Rotation getRotation() {
        return rotation;
    }
    
    public Drawable getDrawable() {
        return drawable;
    }
}
