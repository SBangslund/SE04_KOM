package surgo.kom.common.nodes;

import surgo.kom.common.components.Position;
import surgo.kom.common.components.Render;

/**
 *
 * @author Samuel Bangslund
 */
public class RenderNode extends GameNode {

    @Override
    public GameNode registerNode() {
        super.registerComponent(Render.class);
        super.registerComponent(Position.class);
        return this;
    }
}
