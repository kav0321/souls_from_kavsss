package net.kav.soul.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;

public interface Playeraction{
    int x1 = 0;
    int y = 0;





        Event<Playeraction> EVENT = EventFactory.createArrayBacked(Playeraction.class,
                (listeners) -> (player) -> {
                    for (Playeraction listener : listeners) {
                        ActionResult result = listener.swing(player);

                        if(result != ActionResult.PASS) {
                            return result;
                        }
                    }

                    return ActionResult.PASS;
                });

        ActionResult swing(PlayerEntity player);






}
