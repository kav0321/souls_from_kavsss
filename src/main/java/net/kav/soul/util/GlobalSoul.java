package net.kav.soul.util;

import net.minecraft.client.MinecraftClient;

public class GlobalSoul {

//enable for client to use nbt data
  private static long soulr;
  private static float stamina;
  private static int Itemtype;
  private static boolean IS_THIS_ATK=false;



    public static  long getGlobalSoul()
    {
        return soulr;
    }

    public static void setGlobalSoul(long soul)
    {

        soulr=soul;
    }

  public static  int getItemtype()
  {
    return Itemtype;
  }

  public static void setItemtype(int soul)
  {

    Itemtype=soul;
  }

    public static float getStamina(){return stamina;};
    public static void setStamina(float amount){stamina=amount;}


  public static boolean get_is_this_atk(){return IS_THIS_ATK;};
  public static void set_is_this_atk(boolean amount){IS_THIS_ATK=amount;}


}
