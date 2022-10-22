package net.kav.soul.util;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.kav.soul.client.gui.ExampleGui;
import net.kav.soul.client.gui.ExampleScreen;
import net.kav.soul.client.gui.levelupgui;
import net.minecraft.client.MinecraftClient;

public class DisplayLevel {

    public static void GUi(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> {


            if(levelupcondition.getlevel_conditon()==true)
            {




                MinecraftClient.getInstance().setScreen(new ExampleScreen((new levelupgui())));



                levelupcondition.leveling(((IEntityDataSaver) client.player),false);
            }


        });



    }
}
