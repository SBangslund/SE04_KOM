/*
 * Created by Samuel Bangslund, Odense SDU Software Engineering 1. semester.
 */

package surgo.kom.common;

import java.io.Serializable;

/**
 *
 * @author Samuel Bangslund
 */
public class Event implements Serializable {
  private final Entity source;

    public Event(Entity source) {
        this.source = source;
    }

    public Entity getSource() {
        return source;
    }
}
