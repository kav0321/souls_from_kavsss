package net.kav.soul.util;

import net.minecraft.nbt.NbtCompound;

public class levelupcondition {
    private static boolean level_conditon;
    private static boolean closing_conditionL;
    private static int tradingnum;

    public static int setlevel(IEntityDataSaver player,int amunt)
    {
        NbtCompound nbt = player.getPersistentData();
        tradingnum= nbt.getInt("tradingnum");

        tradingnum=amunt+1;
        nbt.putInt("tradingnum",tradingnum);
        return tradingnum;
    }
    public static Boolean leveling(IEntityDataSaver player,boolean statement)
    {
        NbtCompound nbt = player.getPersistentData();
        level_conditon=nbt.getBoolean("level_conditon");
        closing_conditionL=nbt.getBoolean("closing_conditionL");

        if(statement==false)
        {
            level_conditon=false;


        }
        else
        {
            level_conditon=true;
            closing_conditionL=false;
        }


        nbt.putBoolean("closing_conditionL",closing_conditionL);
        nbt.putBoolean("level_conditon", level_conditon);
        return level_conditon;

    }

    public static Boolean getlevel_conditon()
    {
        return level_conditon;
    }



}
