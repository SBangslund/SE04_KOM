/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package surgo.kom.asteroid;

import org.openide.util.lookup.ServiceProvider;
import surgo.kom.common.components.Asteroid;
import surgo.kom.common.components.CollisionBox;
import surgo.kom.common.components.Position;
import surgo.kom.common.components.Velocity;
import surgo.kom.common.nodes.GameNode;
import surgo.kom.common.nodes.INode;

/**
 *
 * @author sbang
 */
@ServiceProvider(service = INode.class)
public class AsteroidCollisionNode extends GameNode {

    @Override
    public GameNode registerNode() {
        super.registerComponent(Asteroid.class);
        super.registerComponent(CollisionBox.class);
        super.registerComponent(Position.class);
        super.registerComponent(Velocity.class);
        return this;
    }
}
