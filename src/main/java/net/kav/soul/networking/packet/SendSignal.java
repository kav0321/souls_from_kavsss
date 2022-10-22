package net.kav.soul.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.kav.soul.networking.ModMessages;
import net.kav.soul.util.GlobalSoul;
import net.kav.soul.util.IEntityDataSaver;
import net.kav.soul.util.SoulData;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public class SendSignal {


    public static void sendstats(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender)
    {
        long soul= SoulData.addNBTLONGPOINTS(((IEntityDataSaver) player),0,"soul");
        int health= SoulData.addNbtPoints(((IEntityDataSaver) player),0,"Constitution");
        int strength = SoulData.addNbtPoints(((IEntityDataSaver) player),0,"Strength");
        int dex =SoulData.addNbtPoints(((IEntityDataSaver) player),0,"dex");
        int Endurance= SoulData.addNbtPoints(((IEntityDataSaver) player),0,"Endurance");

        PacketByteBuf bufhe= PacketByteBufs.create();
        bufhe.writeInt(health);
        ServerPlayNetworking.send(player, ModMessages.HEALTH,bufhe);
        PacketByteBuf bufse= PacketByteBufs.create();
        bufse.writeInt(strength);
        ServerPlayNetworking.send(player, ModMessages.STRENGTH,bufse);
        PacketByteBuf bufde= PacketByteBufs.create();
        bufde.writeInt(dex);
        ServerPlayNetworking.send(player, ModMessages.DEX,bufde);
        PacketByteBuf bufe= PacketByteBufs.create();
        bufe.writeInt(Endurance);
        ServerPlayNetworking.send(player, ModMessages.ENDURANCE,bufe);


        // ((PlayerEntity) entity).sendMessage(Text.of("h1"),true);


        PacketByteBuf bufss= PacketByteBufs.create();
        //add sound




        bufss.writeLong(soul);

        ServerPlayNetworking.send(player, ModMessages.EXAMPLE_ID,bufss);
    }
}
