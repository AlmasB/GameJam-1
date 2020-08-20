package com.almasb.gamejam;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.KeepOnScreenComponent;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import static com.almasb.fxgl.dsl.FXGL.*;
import static com.almasb.gamejam.EntityType.*;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public class GameFactory implements EntityFactory {

    @Spawns("player")
    public Entity newPlayer(SpawnData data) {
        return entityBuilder(data)
                .type(PLAYER)
                .viewWithBBox(new Rectangle(40, 40, Color.BLUE))
                .view(new Text("DEVICE"))
                .with(new PlayerComponent())
                .with(new KeepOnScreenComponent())
                .collidable()
                .build();
    }

    @Spawns("disk")
    public Entity newDisk(SpawnData data) {
        return entityBuilder(data)
                .type(DISK)
                .viewWithBBox(new Circle(20, 20, 20, Color.RED))
                .with(new DiskComponent())
                .collidable()
                .opacity(0.0)
                .build();
    }

    @Spawns("building")
    public Entity newBuilding(SpawnData data) {
        int width = data.get("width");
        int height = data.get("height");

        return entityBuilder(data)
                .type(BUILDING)
                .viewWithBBox(new Rectangle(width, height, Color.BROWN))
                .collidable()
                .build();
    }
}
