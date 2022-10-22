package net.kav.soul.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.kav.soul.Soul;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {


    public static final ItemGroup SOUL = FabricItemGroupBuilder.build(new Identifier(Soul.MOD_ID,"soul"),
            ()->new ItemStack(Moditems.Golden_Pine));



}
