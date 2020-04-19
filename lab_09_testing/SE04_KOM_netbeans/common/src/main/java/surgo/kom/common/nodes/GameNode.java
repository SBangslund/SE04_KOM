/*
 * Created by Samuel Bangslund, Odense SDU Software Engineering 1. semester.
 */

package surgo.kom.common.nodes;

import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import surgo.kom.common.Entity;
import surgo.kom.common.components.GameComponent;

/**
 *
 * @author Samuel Bangslund
 */
public abstract class GameNode implements INode, Cloneable, Comparator<GameNode> {

    private Map<Class, GameComponent> components;
    private Entity parentEntity;
    
    protected GameNode() {
        components = new HashMap<>();
    }
    
    public GameNode(GameNode node) {
        components = node.getComponents();
    }
    
    public void registerComponent(Class component) {
        components.put(component, null);
    }
    
    public void addComponent(Class componentname, GameComponent component) {
        components.put(componentname, component);
        
    }
    
    public void addComponents(Map<Class, GameComponent> components) {
        components.forEach((c, g) -> {
            if(this.components.containsKey(c)) {
                this.components.put(c, g);
            }
        });
    }
    
    public void removeComponent(Class component) {
        components.remove(component);
    }
    
    public Map<Class, GameComponent> getComponents() {
        return components;
    }
    
    public <T extends GameComponent> T getComponent(Class<T> c) {
        return (T) components.get(c);
    }
    
    public Entity getParentEntity() {
        return parentEntity;
    }
    
    public void setParentEntity(Entity parentEntity) {
        this.parentEntity = parentEntity;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getClass() + "\n");
        for (GameComponent component : components.values()) {
            builder.append("\t" + component + "\n");
        }
        return builder.toString();
    }
    
    @Override
    public GameNode clone() throws CloneNotSupportedException {
        GameNode node = null;
        try {
            node = getClass().getDeclaredConstructor().newInstance();
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            ex.printStackTrace();
        }
        return node;
    }

    @Override
    public int compare(GameNode arg0, GameNode arg1) {
        return 0;
    }
}
