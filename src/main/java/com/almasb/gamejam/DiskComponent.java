package com.almasb.gamejam;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;

import static com.almasb.fxgl.dsl.FXGL.*;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public class DiskComponent extends Component {

    private Entity player;

    @Override
    public void onUpdate(double tpf) {
        if (player == null) {
            player = getGameWorld().getSingleton(EntityType.PLAYER);
        }

        double opacity = 1 - Math.min(1, player.distanceBBox(entity) / 50.0);

        entity.getViewComponent().setOpacity(opacity);
    }
}
