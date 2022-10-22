package net.kav.soul.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.kav.soul.util.IEntityDataSaver;
import net.kav.soul.util.SoulData;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.command.argument.ItemStackArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;

public class setsoul {
    //public static void register(CommandDispatcher<ServerCommandSource> dispatcher, boolean dedicated) {
    //        dispatcher.register(CommandManager.literal("soul").requires((source) -> {
    //                    return source.hasPermissionLevel(2);
    //                }).then(CommandManager.argument("targets", EntityArgumentType.players()).then(CommandManager.literal("amount")).executes(setsoul::run)));
    //    }
    //
    //    private static int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
    //        IEntityDataSaver player = (IEntityDataSaver)context.getSource().getPlayer();
    //
    //        long amount;
    //        SoulData.setsoul(player,amount);
    //
    //    }
}
