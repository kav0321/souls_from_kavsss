package net.kav.soul.event;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.kav.soul.networking.ModMessages;
import net.kav.soul.util.GlobalSoul;
import net.kav.soul.util.IEntityDataSaver;
import net.kav.soul.util.MaxStats;
import net.kav.soul.util.SoulData;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.s2c.play.PlayerSpawnS2CPacket;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;

public class serverstart implements ServerPlayConnectionEvents.Join {


    @Override
    public void onPlayReady(ServerPlayNetworkHandler handler, PacketSender sender, MinecraftServer server) {

        for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList())
        {

        }


    }
}
