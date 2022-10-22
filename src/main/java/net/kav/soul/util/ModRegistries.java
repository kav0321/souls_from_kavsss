package net.kav.soul.util;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.kav.soul.entity.ModEntities;
import net.kav.soul.entity.custom.RaccoonEntity;
import net.kav.soul.event.ModPlayerEventCopyFrom;

//register mobs
public class ModRegistries {

    public static void registerModStuffs(){
        registerAttributes();
        registerEvents();
    }

    private static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.RACCOON, RaccoonEntity.setAttributes());
    }

    private static void registerEvents()
    {
        ServerPlayerEvents.COPY_FROM.register(new ModPlayerEventCopyFrom());
    }
}
