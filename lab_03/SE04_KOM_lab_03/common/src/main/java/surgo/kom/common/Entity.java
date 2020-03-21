package surgo.kom.common;

import java.io.Serializable;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import surgo.kom.common.components.GameComponent;

public class Entity implements Serializable {
    private final UUID ID = UUID.randomUUID();

    private Map<Class, GameComponent> components;
    
    public Entity() {
        components = new ConcurrentHashMap<>();
    }
    
    public void add(GameComponent part) {
        components.put(part.getClass(), part);
    }
    
    public void remove(Class partClass) {
        components.remove(partClass);
    }
    
    public <E extends GameComponent> E getComponent(Class componentClass) {
        return (E) components.get(componentClass);
    }
    
    public Map<Class, GameComponent> getComponents() {
        return components;
    }

    public String getID() {
        return ID.toString();
    }
}
