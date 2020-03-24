package surgo.kom.core.nodes;

import org.openide.util.lookup.ServiceProvider;
import surgo.kom.common.components.Position;
import surgo.kom.common.components.Render;
import surgo.kom.common.nodes.GameNode;
import surgo.kom.common.nodes.INode;

/**
 *
 * @author Samuel Bangslund
 */
@ServiceProvider(service = INode.class)
public class RenderNode extends GameNode {

    @Override
    public GameNode registerNode() {
        super.registerComponent(Render.class);
        super.registerComponent(Position.class);
        return this;
    }
}
