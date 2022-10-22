package net.kav.soul.networking.packet;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.kav.soul.networking.ModMessages;
import net.kav.soul.util.IEntityDataSaver;
import net.kav.soul.util.SoulData;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.UUID;

import static net.kav.soul.util.SoulData.addFloatpoint;

public class PlayerStatsServer {







    public static void sendstats(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender)
    {

        float x=buf.readFloat();

        if(!server.isSingleplayer())
        {
            //player.sendMessage(Text.of(Float.toString(x)),true);
            SoulData.removeFloatpoint(((IEntityDataSaver) player),x,"Stamina");
        }
        //(((IEntityDataSaver) player)).getPersistentData().putFloat("soul",x);
     //  SoulData.removeFloatpoint(((IEntityDataSaver) player),x,"Stamina");

    }

    public static void getsta(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender)
    {

        float x=buf.readFloat();
       // player.sendMessage(Text.of(Float.toString(x)),true);

        float f=addFloatpoint(((IEntityDataSaver) player),x,"Stamina");
        //server.sendSystemMessage(Text.of(Float.toString(f)), UUID.randomUUID());

    }




    public static void getstas(MinecraftClient client, ClientPlayNetworkHandler clientPlayNetworkHandler, PacketByteBuf buf, PacketSender packetSender) {
        float x=buf.readFloat();
        // player.sendMessage(Text.of(Float.toString(x)),true);

        (((IEntityDataSaver) client.player)).getPersistentData().putFloat("Stamina",x);
    }
}
