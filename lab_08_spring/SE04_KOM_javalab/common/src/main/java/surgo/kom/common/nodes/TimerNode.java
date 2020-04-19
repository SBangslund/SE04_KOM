/*
 * Created by Samuel Bangslund, Odense SDU Software Engineering 1. semester.
 */

package surgo.kom.common.nodes;

import surgo.kom.common.components.Timer;

/**
 *
 * @author Samuel Bangslund
 */
public class TimerNode extends GameNode {

    @Override
    public GameNode registerNode() {
        super.registerComponent(Timer.class);
        return this;
    }
}
