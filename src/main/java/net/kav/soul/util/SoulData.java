package net.kav.soul.util;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.kav.soul.data.ItemType;
import net.kav.soul.mixin.ModEntityDataSaverMixin;
//import net.kav.soul.networking.ModMessages;
import net.kav.soul.networking.ModMessages;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import java.util.Random;

import static java.lang.Math.pow;

public class SoulData {

    private static long soul;
    private static int Intimidation_factor;
    private static int Insanity;
    private static  int Random;

    private static int Constitution;
    private static int Strength;
    private static int Level;
    private static int dex;
    private static int Endurance;
    private static int Intelligence;
    private static float Stamina;
    private static int ItemType;
    private static float MaxStamina=20;
    private static boolean Is_This_AN_ATK;



    public static boolean conditions(IEntityDataSaver player, boolean cond,String string)
    {
        NbtCompound nbt = player.getPersistentData();
        Is_This_AN_ATK=nbt.getBoolean("Is_This_AN_ATK");
        switch (string) {
            case "Is_This_AN_ATK":
                Is_This_AN_ATK= cond;
                nbt.putBoolean("Is_This_AN_ATK", Is_This_AN_ATK);

                return Is_This_AN_ATK;
            case "Is_This_AN_ATK2":
                return Is_This_AN_ATK;
            default:
                return false;

        }
    }
public static int returnlevel(IEntityDataSaver player)
{
    NbtCompound nbt = player.getPersistentData();
    Level=nbt.getInt("Level");
    if(Level==0)
    {
        Level=10;
    }


    nbt.putInt("Level",Level);

    return Level;
}

    public static int setlevel(IEntityDataSaver player,int levels)
    {
        NbtCompound nbt = player.getPersistentData();
        Level=nbt.getInt("Level");
        if(Level==0)
        {
            Level=10;
        }
        else
        {
            Level=levels;
        }


        nbt.putInt("Level",Level);

        return Level;
    }

    public static long setsoul(IEntityDataSaver player,int levels)
    {
        NbtCompound nbt = player.getPersistentData();
        soul=nbt.getLong("soul");


          soul=levels;


        nbt.putLong("soul",soul);

        return soul;
    }


public static long addNBTLONGPOINTS(IEntityDataSaver player, int amount,String string)
{

        NbtCompound nbt = player.getPersistentData();
        soul=nbt.getLong("soul");


        switch (string)
        {
            case "soul":

                if (soul >= 9999999) {
                    soul = 9999999;
                } else {
                    soul = soul + amount;
                }
                nbt.putLong("soul", soul);
                // synSoul(soul, (ServerPlayerEntity) player);
                return soul;
            default:
                return 0;
        }

}
    public static int addNbtPoints(IEntityDataSaver player, int amount,String string)
    {
        NbtCompound nbt = player.getPersistentData();
        soul=nbt.getLong("soul");
        Constitution=nbt.getInt("Constitution");
        Strength=nbt.getInt("Strength");
        dex=nbt.getInt("dex");
        Endurance=nbt.getInt("Endurance");
        Level=nbt.getInt("Level");
        Intimidation_factor = nbt.getInt("Intimidation_factor");
        Insanity= nbt.getInt("Insanity");

        MaxStamina=nbt.getFloat("Stamina_re");
        ItemType= nbt.getInt("ItemType");

        if(Level==0)
        {
            Level=10;
        }

        switch (string)
        {

            case "Intimidation_factor" :
                if (Intimidation_factor >= 100) {
                    Intimidation_factor = 100;
                } else {
                    Intimidation_factor = Intimidation_factor + amount;
                }
                nbt.putInt("Intimidation_factor",Intimidation_factor);
                return Intimidation_factor;
            case "Insanity":
                if (Insanity >= 100) {
                    Insanity = 100;
                } else {
                    Insanity = Insanity + amount;
                }
                nbt.putInt("Insanity",Insanity);
                return Insanity;
            case "ItemType":
                ItemType =amount;
                nbt.putInt("ItemType",ItemType);
                //GlobalSoul.setItemtype(amount);
                return ItemType;
            case "ItemType2":
                //GlobalSoul.setItemtype(amount);
                return ItemType;
                //do nothing for now
            case "Constitution":
                if (Constitution >= 100) {
                    Constitution = 100;
                }
                else if (Constitution==0)
                {
                    Constitution=0;
                }
                else {

                    Constitution = Constitution + amount;
                }
                nbt.putInt("Constitution",Constitution);
                nbt.putInt("Level",Level);
                return Constitution;
            case "Strength":
                if (Strength >= 100) {
                    Strength = 100;
                }
                else if (Strength==0)
                {
                    Strength=0;
                }
                else {
                    Strength = Strength + amount;

                }
                nbt.putInt("Strength",Strength);
                nbt.putInt("Level",Level);
                return Strength;
            case "dex":
                if (dex >= 100) {
                    dex = 100;
                }
                else if (dex==0)
                {
                dex=0;
                }
                else {
                    dex = dex + amount;

                }
                nbt.putInt("dex",dex);
                nbt.putInt("Level",Level);
                return dex;
            case "Endurance":
                if (Endurance >= 100) {
                    Endurance = 100;
                }
                else if (Endurance==0)
                {
                    Endurance=0;
                }
                else {
                    Endurance = Endurance + amount;


                }
                nbt.putInt("Endurance",Endurance);
                nbt.putInt("Level",Level);
                return Endurance;
            default:
                return 0;
        }
    }

    public static float addFloatpoint(IEntityDataSaver player,float amount, String string)
    {
        NbtCompound nbt = player.getPersistentData();
      //  Stamina=nbt.getFloat("Stamina");
        MaxStamina=nbt.getFloat("Stamina_re");
        //Stamina=10;

        switch (string) {
            case "Stamina":

                if (Stamina >= MaxStats.getMaxstamina()) {
                    Stamina = MaxStats.getMaxstamina();
                }else
                {
                    Stamina = Stamina + amount;
                }
               // nbt.putFloat("Stamina", Stamina);
                GlobalSoul.setStamina(Stamina);
                return Stamina;

            case "MaxStamina":
                if(MaxStamina>99)
                {
                    MaxStamina=99;
                }
                else
                {MaxStamina = MaxStamina + amount;}
                nbt.putFloat("MaxStamina", MaxStamina);

                MaxStats.setMaxstamina(MaxStamina);
                return MaxStamina;
            //do nothing for now
            default:
                return 2;
        }
    }

    public static float removeFloatpoint(IEntityDataSaver player,float amount, String string)
    {
        NbtCompound nbt = player.getPersistentData();
      //  Stamina=nbt.getFloat("Stamina");
        //Stamina=nbt.getFloat("Stamina");
        MaxStamina=nbt.getFloat("Stamina_re");


        switch (string) {
            case "Stamina":

               if (Stamina<=0) {
                    Stamina=0;

                   //ClientPlayNetworking.send(ModMessages.COMMAND2,PacketByteBufs.empty());
                }
               else
               {Stamina = Stamina - amount;}

                GlobalSoul.setStamina(Stamina);
          //  nbt.putFloat("Stamina", Stamina);
             //  synSoul(Stamina, (ServerPlayerEntity) player);
            return Stamina;
            // synSoul(soul, (ServerPlayerEntity) player);

            //do nothing for now
            default:
                return -1000;
        }
    }

    public static int removeNbtPoints(IEntityDataSaver player, int amount,String string)
    {
        NbtCompound nbt = player.getPersistentData();
        Intimidation_factor = nbt.getInt("Intimidation_factor");
        Insanity= nbt.getInt("Insanity");

        switch (string)
        {
            case "Intimidation_factor" :
                if (Intimidation_factor <0) {
                    Intimidation_factor = 0;
                } else {
                    Intimidation_factor = Intimidation_factor - amount;
                }
                nbt.putInt("Intimidation_factor",Intimidation_factor);
                return Intimidation_factor;
            case "Insanity":
                if (Insanity <0) {
                    Insanity = 0;
                } else {
                    Insanity = Insanity - amount;
                }
                nbt.putInt("Insanity",Insanity);
                return Insanity;
            case "Constitution":
                if (Constitution <= 0) {
                    Constitution = 0;
                } else {
                    Constitution = Constitution - amount;
                }
                nbt.putInt("Constitution",Constitution);
                return Constitution;
            case "Strength":
                if (Strength <= 0) {
                    Strength = 0;
                } else {
                    Strength = Strength - amount;
                }
                nbt.putInt("Strength",Strength);
                return Strength;
            case "dex":
                if (dex <= 0) {
                    dex = 0;
                } else {
                    dex = dex - amount;
                }
                nbt.putInt("dex",dex);
                return dex;
            case "Endurance":
                if (Endurance <= 0) {
                    Endurance = 0;
                } else {
                    Endurance = Endurance - amount;
                }
                nbt.putInt("Endurance",Endurance);
                return Endurance;
            //do nothing for now
            default:
                return 0;
        }
    }

    public static long getSoul(IEntityDataSaver player)
    {
        NbtCompound nbt = player.getPersistentData();
        soul=nbt.getLong("soul");
        nbt.putLong("soul", soul);
        return soul;
    }

    public static int random(IEntityDataSaver entity)
    {
        NbtCompound nbt = entity.getPersistentData();
        Random =nbt.getInt("random");

        int rands=0;
        int[] digits= new int[5];
        Random rand = new Random();


        for(int i=0;i<5;i++)
        {
            digits[i]=rand.nextInt(1,9);

            if(i!=0)
            {
                rands= digits[i]*((int) pow(10, i))+rands;


            }
            else
            {
                rands= digits[i]*((int) pow(10, i));



            }

        }


        Random=rands;

        nbt.putInt("random",Random);
        return Random;

    }

    public static int setRandom(IEntityDataSaver entity,int amount)
    {
        NbtCompound nbt = entity.getPersistentData();
        Random =nbt.getInt("random");

        Random=amount;
        nbt.putInt("random",Random);
        return Random;
    }
    public static int getRandom(IEntityDataSaver entity)
    {

        return Random;
    }








}