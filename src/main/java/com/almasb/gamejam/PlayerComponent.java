package com.almasb.gamejam;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;

import java.util.List;

import static com.almasb.fxgl.dsl.FXGL.*;

/**
 * // TODO: refactor movement into TopDownMoveComponent
 *
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public class PlayerComponent extends Component {

    private List<Entity> buildings;

    @Override
    public void onAdded() {
        buildings = getGameWorld().getEntitiesByType(EntityType.BUILDING);
    }

    public void moveLeft() {
        for (int x = 0; x < 5; x++) {
            entity.translateX(-1);

            // if collision
            if (buildings.stream().anyMatch(b -> b.isColliding(entity))) {
                entity.translateX(1);
            }
        }
    }

    public void moveRight() {
        for (int x = 0; x < 5; x++) {
            entity.translateX(1);

            // if collision
            if (buildings.stream().anyMatch(b -> b.isColliding(entity))) {
                entity.translateX(-1);
            }
        }
    }

    public void moveUp() {
        for (int x = 0; x < 5; x++) {
            entity.translateY(-1);

            // if collision
            if (buildings.stream().anyMatch(b -> b.isColliding(entity))) {
                entity.translateY(1);
            }
        }
    }

    public void moveDown() {
        for (int x = 0; x < 5; x++) {
            entity.translateY(1);

            // if collision
            if (buildings.stream().anyMatch(b -> b.isColliding(entity))) {
                entity.translateY(-1);
            }
        }
    }
}
