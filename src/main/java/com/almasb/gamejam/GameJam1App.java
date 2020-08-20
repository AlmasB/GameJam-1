package com.almasb.gamejam;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.SpawnData;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.input.KeyCode;

import static com.almasb.fxgl.dsl.FXGL.*;
import static com.almasb.gamejam.EntityType.*;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public class GameJam1App extends GameApplication {

    private Entity player;

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setTitle("City Disk Device");
        settings.setWidth(1280);
        settings.setHeight(720);
    }

    @Override
    protected void initInput() {
        onKey(KeyCode.W, () -> {
            player.call("moveUp");
        });

        onKey(KeyCode.A, () -> {
            player.call("moveLeft");
        });

        onKey(KeyCode.S, () -> {
            player.getComponent(PlayerComponent.class).moveDown();
        });

        onKey(KeyCode.D, () -> {
            player.getComponent(PlayerComponent.class).moveRight();
        });
    }

    @Override
    protected void initGame() {
        getGameWorld().addEntityFactory(new GameFactory());

        for (int y = 0; y < getAppHeight(); y += 300) {
            for (int x = 0; x < getAppWidth(); x += 300) {
                if (x == 0 && y == 0)
                    continue;

                if (FXGLMath.randomBoolean(0.5)) {
                    int width = random(150, 300);
                    int height = random(150, 300);

                    //Point2D p = FXGLMath.randomPoint(new Rectangle2D(0, 0, getAppWidth(), getAppHeight()));
                    Point2D p = new Point2D(x, y);

                    spawn("building", new SpawnData(p).put("width", width).put("height", height));
                } else if (FXGLMath.randomBoolean(0.5)) {
                    spawn("disk", x, y);
                }
            }
        }

        player = spawn("player", 0, 0);
    }

    @Override
    protected void initPhysics() {
        onCollisionCollectible(PLAYER, DISK, disk -> {

        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}