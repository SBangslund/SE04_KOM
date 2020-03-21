package surgo.kom.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;
import surgo.kom.common.components.GameComponent;
import surgo.kom.common.nodes.GameNode;
import surgo.kom.common.nodes.INode;
import surgo.kom.common.nodes.NodeList;

/**
 *
 * @author jcs
 */
public class World {

    private final Map<String, Entity> entityMap = new ConcurrentHashMap<>();
    private final Map<Entity, List<GameNode>> entityNodes = new HashMap<>();
    private final NodeList<GameNode> nodeTypes = new NodeList();
    private final Map<Class, List<GameNode>> allNodes = new HashMap<>();
    
    public World() {
        for (INode node : ServiceLoader.load(INode.class)) {
            nodeTypes.add(node.registerNode());
        }
    }
    
    private List<GameNode> extractNodes(Map<Class, GameComponent> components) {
        List<GameNode> extractedNodes = new ArrayList<>();
        for (GameNode nodeType : nodeTypes.getNodes().values()) {
            if(components.keySet().containsAll(nodeType.getComponents().keySet())) {
                try {
                    GameNode node = nodeType.clone();
                    for(GameComponent component : components.values()) {
                        if(nodeType.getComponents().containsKey(component.getClass())) {
                            node.addComponent(component.getClass(), component);
                        }
                    }
                    extractedNodes.add(node);
                } catch (CloneNotSupportedException ex) {
                    ex.printStackTrace();
                }
            }
        }      
        return extractedNodes;
    }
    
    private void distributeNodes(List<GameNode> nodeList, Entity entity) {
            entityNodes.put(entity, nodeList);
        for (GameNode node : nodeList) {
            List<GameNode> gameNodes = allNodes.get(node.getClass());
            if(gameNodes != null) {
                gameNodes.add(node);
            } else {
                List<GameNode> newGameNodes = new ArrayList<>();
                newGameNodes.add(node);
                allNodes.put(node.getClass(), newGameNodes);
            }
            node.setParentEntity(entity);
        }
    }
    
    public <E extends GameNode> void sortListBy(Class listToSort, Comparator<E> comparator) {
        List<E> retrievedList = (List<E>) allNodes.get(listToSort);
        Collections.sort(retrievedList, comparator);
    }
        
    public String addEntity(Entity entity) {
        entityMap.put(entity.getID(), entity);
        distributeNodes(extractNodes(entity.getComponents()), entity);
        return entity.getID();
    }

    public void removeEntity(Entity entity) {
        List<GameNode> entitiesNodes = entityNodes.get(entity);
        if(entitiesNodes != null) {
            for (GameNode entitiesNode : entitiesNodes) {
                List<GameNode> relevant = allNodes.get(entitiesNode.getClass());
                relevant.remove(entitiesNode);
            }        
            entityNodes.remove(entity); 
        }
        entityMap.remove(entity.getID());
    }
    
    public Map<Class, List<GameNode>> getNodes() {
        return allNodes;
    }
    
    public <E extends GameNode> List<E> getNodes(Class<E> c) {
        List<E> result = (List<E>) allNodes.get(c);
        return result != null ? result : new ArrayList<>();
    }
    
    public Collection<Entity> getEntities() {
        return entityMap.values();
    }

    public <E extends Entity> List<Entity> getEntities(Class<E>... entityTypes) {
        List<Entity> r = new ArrayList<>();
        for (Entity e : getEntities()) {
            for (Class<E> entityType : entityTypes) {
                if (entityType.equals(e.getClass())) {
                    r.add(e);
                }
            }
        }
        return r;
    }

    public Entity getEntity(String ID) {
        return entityMap.get(ID);
    }

}
