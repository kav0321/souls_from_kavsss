package net.kav.soul.data;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ItemData {
    //thx to villagerquesting mod I managed to do this. This code belongs to the author of villagerquesting.
    public static final ArrayList<List<Object>> itemname = new ArrayList<>();
    public static final List<Integer> soulnumber = new ArrayList<Integer>();
    //public static final ArrayList<Object> ID = new ArrayList<Object>();//1-5
    //    public static final ArrayList<Object> ID_1_9 = new ArrayList<Object>();//1-5
    // Title
    public static final List<String> ItemName = new ArrayList<String>();

    public ItemData()
    {
        ItemName.add("minecraft:diamond_axe");
        soulnumber.add(1);

    }

    public static List<? extends Object> getList(String string)
    {
        switch (string){
            case "Itemsoul":
                return soulnumber;

            case "Itemname":
                return ItemName;

            default:
                return new ArrayList<Object>();
        }
    }


    public static ArrayList<String> getListNames(){
        ArrayList<String> listNames = new ArrayList<String>();

        listNames.add("Itemname");
        listNames.add("Itemsoul");

        return listNames;
    }



}
