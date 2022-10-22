package net.kav.soul.networking;

import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.kav.soul.Soul;
import net.kav.soul.event.EntityDeath;
import net.kav.soul.networking.packet.PlayerStatsServer;
import net.kav.soul.networking.packet.SendSignal;
import net.kav.soul.networking.packet.TradingServer;
import net.kav.soul.networking.packet.commandspackets;
import net.kav.soul.util.*;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

public class ModMessages {

    public static final Identifier EXAMPLE_ID = new Identifier(Soul.MOD_ID, "example");


    public static final Identifier TRADING = new Identifier(Soul.MOD_ID, "trading");
    public static final Identifier ESCAPE = new Identifier(Soul.MOD_ID, "escape");
    public static final Identifier RANDOM = new Identifier(Soul.MOD_ID, "random");
    public static final Identifier COMMAND = new Identifier(Soul.MOD_ID, "command");
    public static final Identifier COMMAND2 = new Identifier(Soul.MOD_ID, "commandtwo");

    public static final Identifier HANDSWING = new Identifier(Soul.MOD_ID, "handswing");
    public static final Identifier STAMINA = new Identifier(Soul.MOD_ID, "stamina");
    public static final Identifier STAMINA2 = new Identifier(Soul.MOD_ID, "staminaa");
    public static final Identifier STA_AT_ZERO = new Identifier(Soul.MOD_ID, "sta_at_zero");
    public static final Identifier ITEM_TYPE = new Identifier(Soul.MOD_ID, "item_type");
    public static final Identifier IS_THIS_AN_ATK = new Identifier(Soul.MOD_ID, "is_this_an_atk");
    public static final Identifier LEVEL = new Identifier(Soul.MOD_ID, "level");
    public static final Identifier HEALTH = new Identifier(Soul.MOD_ID, "health");
    public static final Identifier STRENGTH = new Identifier(Soul.MOD_ID, "strength");
    public static final Identifier DEX = new Identifier(Soul.MOD_ID, "dex");
    public static final Identifier ENDURANCE = new Identifier(Soul.MOD_ID, "endurance");
    public static final Identifier SOULS = new Identifier(Soul.MOD_ID, "souls");


    public static void registerC2SPackets() {

        ServerPlayNetworking.registerGlobalReceiver(ESCAPE, TradingServer::sendescapeinforeceive);
        ServerPlayNetworking.registerGlobalReceiver(COMMAND, commandspackets::commands);
        ServerPlayNetworking.registerGlobalReceiver(COMMAND2, commandspackets::commandsta);
       // ServerPlayNetworking.registerGlobalReceiver(HANDSWING, PlayerStatsServer::sendstats);
        ServerPlayNetworking.registerGlobalReceiver(STAMINA, PlayerStatsServer::getsta);
        ServerPlayNetworking.registerGlobalReceiver(LEVEL, SendSignal::sendstats);


    }

    public static void registerS2CPackets() {
        //ClientPlayNetworking.registerGlobalReceiver(HANDSWING, PlayerStatsServer::sendstats);
        ClientPlayNetworking.registerGlobalReceiver(RANDOM, (client, handler, buf, respondSender) ->
        {
            //(((IEntityDataSaver) client.player)).getPersistentData().putInt("random",buf.readInt());
            boolean x = MinecraftClient.getInstance().isInSingleplayer();
            if (x != true) {
                int a = buf.readInt();
                SoulData.setRandom(((IEntityDataSaver) client.player), a);
            }

        });

        ClientPlayNetworking.registerGlobalReceiver(HANDSWING, (client, handler, buf, respondSender) ->
        {
            boolean x = MinecraftClient.getInstance().isInSingleplayer();
            if (x != true) {
            //(((IEntityDataSaver) client.player)).getPersistentData().putInt("random",buf.readInt());
            SoulData.removeFloatpoint(((IEntityDataSaver) client.player),buf.readFloat(),"Stamina");
            }

        });


        ClientPlayNetworking.registerGlobalReceiver(EXAMPLE_ID, (client, handler, buf, respondSender) ->
        {
            (((IEntityDataSaver) client.player)).getPersistentData().putInt("soul", buf.readInt());
            GlobalSoul.setGlobalSoul(buf.readInt());


        });


        ClientPlayNetworking.registerGlobalReceiver(TRADING, (client, handler, buf, respondSender) ->
        {
            // (((IEntityDataSaver) client.player)).getPersistentData().putBoolean("trading_condition",buf.readBoolean());

            //boolean x= MinecraftClient.getInstance().isInSingleplayer();
            //            if(x!=true)
            //            {
            //
            //            }
            boolean con = TradingCondition.trading((IEntityDataSaver) client.player, true);


        });





        ClientPlayNetworking.registerGlobalReceiver(STAMINA2,PlayerStatsServer::getstas);


       // ClientPlayNetworking.registerGlobalReceiver(STAMINA2, (client, handler, buf, respondSender) ->
        //        {
        //            //(((IEntityDataSaver) client.player)).getPersistentData().putFloat("Stamina",buf.readFloat());
        //            float xa;
        //            boolean x = MinecraftClient.getInstance().isInSingleplayer();
        //            if (x != true) {
        //              //  client.player.sendMessage(Text.of("oh yeye"), true);
        //                float x1 = buf.readFloat();
        //
        //                SoulData.removeFloatpoint(((IEntityDataSaver) client.player), x1, "Stamina");
        //                MaxStats.increaseMaxstamina(0);
        //
        //            }
        //
        //        });

        ClientPlayNetworking.registerGlobalReceiver(STA_AT_ZERO, (client, handler, buf, respondSender) ->
        {


            //(((IEntityDataSaver) client.player)).getPersistentData().putFloat("Stamina",buf.readFloat());
            boolean x = MinecraftClient.getInstance().isInSingleplayer();
            if (x != true) {
                SoulData.addFloatpoint(((IEntityDataSaver) client.player), 15, "MaxStamina");
            }
        });


        ClientPlayNetworking.registerGlobalReceiver(ITEM_TYPE, (client, handler, buf, respondSender) ->
        {

            //(((IEntityDataSaver) client.player)).getPersistentData().putInt("ItemType",);
            boolean x = MinecraftClient.getInstance().isInSingleplayer();
            if (x != true) {
               // SoulData.addFloatpoint(((IEntityDataSaver) client.player), buf.readInt(), "ItemType");
            }
            GlobalSoul.setItemtype(buf.readInt());
        });

        ClientPlayNetworking.registerGlobalReceiver(IS_THIS_AN_ATK, (client, handler, buf, respondSender) ->
        {

            SoulData.conditions(((IEntityDataSaver) client.player),buf.readBoolean(),"Is_This_AN_ATK");
            GlobalSoul.set_is_this_atk(buf.readBoolean());
        });

        ClientPlayNetworking.registerGlobalReceiver(HEALTH, (client, handler, buf, respondSender) ->
        {

            (((IEntityDataSaver) client.player)).getPersistentData().putInt("Constitution",buf.readInt());

        });

        ClientPlayNetworking.registerGlobalReceiver(STRENGTH, (client, handler, buf, respondSender) ->
        {

            (((IEntityDataSaver) client.player)).getPersistentData().putInt("Strength",buf.readInt());

        });

        ClientPlayNetworking.registerGlobalReceiver(DEX, (client, handler, buf, respondSender) ->
        {

            (((IEntityDataSaver) client.player)).getPersistentData().putInt("dex",buf.readInt());

        });

        ClientPlayNetworking.registerGlobalReceiver(ENDURANCE, (client, handler, buf, respondSender) ->
        {
            (((IEntityDataSaver) client.player)).getPersistentData().putInt("Endurance",buf.readInt());


        });

        ClientPlayNetworking.registerGlobalReceiver(SOULS, (client, handler, buf, respondSender) ->
        {
           // client.player.sendMessage(Text.of(Long.toString(buf.readLong())),true);
            //SoulData.addNBTLONGPOINTS(((IEntityDataSaver) client.player),0,"soul");
          // GlobalSoul.setGlobalSoul(SoulData.addNBTLONGPOINTS(((IEntityDataSaver) client.player),0,"soul"));
            client.player.sendMessage(Text.of(Long.toString(buf.readInt())),true);
            (((IEntityDataSaver) client.player)).getPersistentData().putInt("soul", buf.readInt());
            GlobalSoul.setGlobalSoul(buf.readInt());
        });


    }
}