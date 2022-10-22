package net.kav.soul.event;

import com.google.common.collect.Multimap;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.kav.soul.data.ItemData;
import net.kav.soul.data.ItemType;
import net.kav.soul.networking.ModMessages;
import net.kav.soul.util.GlobalSoul;
import net.kav.soul.util.IEntityDataSaver;
import net.kav.soul.util.MaxStats;
import net.kav.soul.util.SoulData;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import java.util.Iterator;
import java.util.Map;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class serverevent implements ServerTickEvents.EndTick {
    int x1 = 0;
    int y=0;
    int x12;
    @Override
    public void onEndTick(MinecraftServer server) {

        //final int y =server.getTicks();

        x1++;
        if (x1 >= 11) {
            x1 = 0;

        }


        for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
            
            double d = 0;
            ItemStack itemss = player.getMainHandStack();
            Item item = itemss.getItem();
            Multimap<EntityAttribute, EntityAttributeModifier> multimap = itemss.getAttributeModifiers(EquipmentSlot.MAINHAND);
            if (!multimap.isEmpty()) {
                Iterator var11 = multimap.entries().iterator();
                while(var11.hasNext()) {
                    Map.Entry<EntityAttribute, EntityAttributeModifier> entry = (Map.Entry)var11.next();
                    EntityAttributeModifier entityAttributeModifier = (EntityAttributeModifier)entry.getValue();
                     d = entityAttributeModifier.getValue();

                }
                //EntityAttributeModifier entityAttributeModifier = (EntityAttributeModifier) item.getAttributeModifiers(EquipmentSlot.MAINHAND).get(EntityAttributes.GENERIC_ATTACK_SPEED);
                    d=abs(d);
                player.sendMessage(Text.of(Double.toString(d)),true);
            }

                ItemType types= new ItemType();


                //////player.sendMessage(Text.of(Float.toString(SoulData.addFloatpoint(((IEntityDataSaver) player), 0f, "Stamina"))),true);


            if(player.isCreative())
            {
                x12=0;
            }
            if(player.handSwinging!=true)
            {
                x12=0;
               // player.sendMessage(Text.of("ok"),true);
                SoulData.conditions(((IEntityDataSaver) player),true,"Is_This_AN_ATK");
            }
            else
            {
                player.sendMessage(Text.of("ok"),true);
                if(types.ItemNames(item)&&SoulData.conditions(((IEntityDataSaver) player),false,"Is_This_AN_ATK2")==true)//true does nothing here
                {

                    x12=ItemType.item.get(item)/2;

                }
                else
                    x12=0;


            }
            float x= SoulData.removeFloatpoint(((IEntityDataSaver) player),x12,"Stamina");
            PacketByteBuf buf = PacketByteBufs.create();
            buf.writeFloat(x12);





            ServerPlayNetworking.send(player,ModMessages.HANDSWING, buf);



           // player.sendMessage(Text.of(Integer.toString(x12)),true);
                PacketByteBuf bufss = PacketByteBufs.create();
                bufss.writeInt(x12);
                SoulData.addNbtPoints(((IEntityDataSaver) player), x12, "ItemType");
               ServerPlayNetworking.send(player, ModMessages.ITEM_TYPE, bufss);


if(SoulData.addFloatpoint(((IEntityDataSaver) player),0,"Stamina")<1)
{
    String xa= player.getName().getString();
    server.getCommandManager().execute(new ServerCommandSource(CommandOutput.DUMMY,player.getPos(),player.getRotationClient(), player.getWorld(),4,"", Text.of("k"), server,player),"effect give "+xa+" minecraft:weakness 2 3 true");
}
    //player.sendMessage(Text.of(Integer.toString(y)),false);




        }



    }
}
