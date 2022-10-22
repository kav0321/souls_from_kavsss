package net.kav.soul.block.custom;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.kav.soul.client.gui.ExampleScreen;
import net.kav.soul.client.gui.levelupgui;
import net.kav.soul.item.Moditems;
import net.kav.soul.networking.ModMessages;
import net.kav.soul.util.IEntityDataSaver;
import net.kav.soul.util.TradingCondition;
import net.kav.soul.util.levelupcondition;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Alter extends Block {
    public Alter(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack mainHand = player.getStackInHand(hand);

        if(mainHand.isOf(Moditems.Golden_Pine))
        {
            PacketByteBuf buf = PacketByteBufs.create();
            //player.sendMessage(Text.of("inter"),true);
            boolean x1=  levelupcondition.leveling(((IEntityDataSaver) player), true);
           // player.sendMessage(Text.of(Boolean.toString(x1)),true);


            ClientPlayNetworking.send(ModMessages.LEVEL,PacketByteBufs.empty());
             return ActionResult.PASS;
        }
        else
            return ActionResult.FAIL;
    }

}
