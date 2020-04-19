/*
 * Created by Samuel Bangslund, Odense SDU Software Engineering 1. semester.
 */

package surgo.kom.common.nodes;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Samuel Bangslund
 */
public class NodeList<T extends GameNode> {
    private Map<Class, T> nodes;
    
    public NodeList() {
        nodes = new HashMap<>();
    }
    
    public void add(GameNode node) {
        nodes.put(node.getClass(), (T) node);
    }
    
    public void remove(Class nodeClass) {
        nodes.remove(nodeClass);
    }
    
    public T getNode(Class node) {
        return (T) nodes.get(node);
    }
    
    public Map<Class, T> getNodes() {
        return nodes;
    }
}
