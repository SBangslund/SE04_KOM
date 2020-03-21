package surgo.kom.core.nodes;

import surgo.kom.common.components.Position;
import surgo.kom.common.components.Render;
import surgo.kom.common.nodes.GameNode;

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
