package net.kav.soul.event;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.kav.soul.util.IEntityDataSaver;
import net.minecraft.server.network.ServerPlayerEntity;

public class ModPlayerEventCopyFrom  implements ServerPlayerEvents.CopyFrom{
    @Override
    public void copyFromPlayer(ServerPlayerEntity oldPlayer, ServerPlayerEntity newPlayer, boolean alive) {
        IEntityDataSaver original = ((IEntityDataSaver) oldPlayer);
        IEntityDataSaver player = ((IEntityDataSaver) newPlayer);

        player.getPersistentData().putIntArray("Constitution", original.getPersistentData().getIntArray("Constitution"));
        player.getPersistentData().putIntArray("Strength", original.getPersistentData().getIntArray("Strength"));
        player.getPersistentData().putIntArray("dex", original.getPersistentData().getIntArray("dex"));
        player.getPersistentData().putIntArray("Endurance", original.getPersistentData().getIntArray("Endurance"));
        player.getPersistentData().putIntArray("Level", original.getPersistentData().getIntArray("Level"));
    }
}
