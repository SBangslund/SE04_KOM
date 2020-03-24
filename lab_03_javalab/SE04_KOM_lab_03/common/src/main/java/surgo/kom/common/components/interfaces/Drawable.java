/*
 * Created by Samuel Bangslund, Odense SDU Software Engineering 1. semester.
 */
package surgo.kom.common.components.interfaces;

import surgo.kom.common.components.Rotation;

/**
 *
 * @author sbang
 */
public interface Drawable {
    void draw(float[] shapex, float[] shapey, Rotation rotation);
}
