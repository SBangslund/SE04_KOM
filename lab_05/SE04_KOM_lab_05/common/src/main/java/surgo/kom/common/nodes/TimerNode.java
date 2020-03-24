/*
 * Created by Samuel Bangslund, Odense SDU Software Engineering 1. semester.
 */

package surgo.kom.common.nodes;

import org.openide.util.lookup.ServiceProvider;
import surgo.kom.common.components.Timer;

/**
 *
 * @author Samuel Bangslund
 */
@ServiceProvider(service = INode.class)
public class TimerNode extends GameNode {

    @Override
    public GameNode registerNode() {
        super.registerComponent(Timer.class);
        return this;
    }
}
