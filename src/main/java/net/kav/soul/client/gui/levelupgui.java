package net.kav.soul.client.gui;

import io.github.cottonmc.cotton.gui.client.BackgroundPainter;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WDynamicLabel;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import net.kav.soul.Soul;
import net.kav.soul.util.GlobalSoul;
import net.kav.soul.util.IEntityDataSaver;
import net.kav.soul.util.SoulData;
import net.kav.soul.util.levelingsystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static io.github.cottonmc.cotton.gui.client.BackgroundPainter.createLightDarkVariants;
import static io.github.cottonmc.cotton.gui.client.BackgroundPainter.createNinePatch;
import static net.kav.soul.client.gui.color.Argb;

public class levelupgui extends LightweightGuiDescription {
    //opens when server sends packets and all level of the client
    private static final Identifier Soul_kavw22= new Identifier(Soul.MOD_ID,"textures/gui/pale_panel_dark.png");



    private static WDynamicLabel labelc1;
    private static  WDynamicLabel labels1;
    private static WDynamicLabel labeld1;
    private static WDynamicLabel labele1;
    private static long souling= GlobalSoul.getGlobalSoul();
    private static long soulingc=souling;
    private static int level =  SoulData.returnlevel(((IEntityDataSaver) MinecraftClient.getInstance().player));
    private static int CONS =  SoulData.addNbtPoints(((IEntityDataSaver) MinecraftClient.getInstance().player),0,"Constitution");
    private static int STR =  SoulData.addNbtPoints(((IEntityDataSaver) MinecraftClient.getInstance().player),0,"Strength");
    private static int DEX =  SoulData.addNbtPoints(((IEntityDataSaver) MinecraftClient.getInstance().player),0,"dex");
    private static int END =  SoulData.addNbtPoints(((IEntityDataSaver) MinecraftClient.getInstance().player),0,"Endurance");

    private static int CONSc = CONS;
    private static int STRc =  STR;
    private static int DEXc =  DEX;
    private static int ENDc=END;


    private static  long req = levelingsystem.reqcal(level);
    private static long reqcopy=req;
    private static int levelcopy=level;

    WGridPanel root = (WGridPanel) rootPanel;
    BackgroundPainter SOUL= createLightDarkVariants((createNinePatch(Soul_kavw22)), createNinePatch(Soul_kavw22));
    @Override
      public void addPainters()
      {
        if (this.root != null && !this.fullscreen) {
             this.root.setBackgroundPainter(SOUL);
           }
        }

    public levelupgui()
    {

        soulingc=GlobalSoul.getGlobalSoul();
        souling=soulingc;
        int width = MinecraftClient.getInstance().getWindow().getScaledWidth();
        int heigth =MinecraftClient.getInstance().getWindow().getScaledHeight();
        int ux=width/2;
        int uy=heigth;
        setRootPanel(root);
        root.setSize(240, 200);
        root.setInsets(Insets.ROOT_PANEL);

        WDynamicLabel label;
        WDynamicLabel labelo;
        WDynamicLabel labelos;
        WDynamicLabel labes;
        WDynamicLabel labelc;
        WDynamicLabel labels;
        WDynamicLabel labeld;
        WDynamicLabel labele;

         label = new WDynamicLabel(() ->"Level    "+ Integer.toString(level));
        label.setColor(Argb,Argb);
        labelo = new WDynamicLabel(() ->"Current Soul    "+ Long.toString(souling));
        labelo.setColor(Argb,Argb);

        labelos = new WDynamicLabel(() ->"                    "+ Long.toString(soulingc));
        labelos.setColor(Argb,Argb);

        labes = new WDynamicLabel(() ->"Souls Require    "+ Long.toString(reqcopy));
        labes.setColor(Argb,Argb);


        labelc = new WDynamicLabel(() ->"CONS    "+ Integer.toString(CONS));
        labelc.setColor(Argb,Argb);

        labels = new WDynamicLabel(() ->"STR      "+ Integer.toString(STR));
        labels.setColor(Argb,Argb);

        labeld = new WDynamicLabel(() ->"DEX      "+ Integer.toString(DEX));
        labeld.setColor(Argb,Argb);

        labele = new WDynamicLabel(() ->"END      "+ Integer.toString(END));
        labele.setColor(Argb,Argb);
        root.add(label,0,0);
        root.add(labelo,3,10);
        root.add(labelos,0,2);
        root.add(labes,0,1);
        root.add(labelc,0,5);
        root.add(labels,0,6);
        root.add(labeld,0,7);
        root.add(labele,0,8);

        WButtonLeft leC = new WButtonLeft();
        WButtonRight reC= new WButtonRight();
        root.add(leC,3,5);
        root.add(reC,5,5);

        WButtonLeft leS = new WButtonLeft();
        WButtonRight reS= new WButtonRight();
        Wbuy confirm= new Wbuy(Text.of("Confirm"));
        root.add(leS,3,6);
        root.add(reS,5,6);
        root.add(confirm,0,10);

        WButtonLeft leD = new WButtonLeft();
        WButtonRight reD= new WButtonRight();
        root.add(leD,3,7);
        root.add(reD,5,7);

        WButtonLeft leE = new WButtonLeft();
        WButtonRight reE= new WButtonRight();
        root.add(leE,3,8);
        root.add(reE,5,8);

        labels_wh();

        root.add(labelc1,4,5);
        root.add(labels1,4,6);
        root.add(labeld1,4,7);
        root.add(labele1,4,8);



        reC.setOnClick(() -> {

            if(soulmeets())
            {
                increase_copy_req(0);
                labels_green(0);
                leC.setEnabled(true);
            }
        });

        leC.setOnClick(() -> {

            if(decrease(0)==false)
            {
                labels_red(0);
                leC.setEnabled(false);
            }


        });



        reS.setOnClick(() -> {
            if(soulmeets())
            {

                labels_green(1);
                increase_copy_req(1);
                leS.setEnabled(true);
            }
        });

        leS.setOnClick(() -> {

            if(decrease(1)==false)
            {
                labels_red(1);

                leS.setEnabled(false);
            }
        });


        reD.setOnClick(() -> {
            if(soulmeets())
            {
                labels_green(2);
                increase_copy_req(2);
                leD.setEnabled(true);
            }
        });

        leD.setOnClick(() -> {

            if(decrease(2)==false)
            {
                labels_red(2);

            }
        });
        leD.setEnabled(true);
        reE.setOnClick(() -> {
            if(soulmeets())
            {
                increase_copy_req(3);
                leE.setEnabled(true);
            }
        });

        leE.setOnClick(() -> {

            if(decrease(0)==false)
            {
                labels_red(3);
                leE.setEnabled(false);
            }
        });



        root.add(labelc1,4,5);
        root.add(labels1,4,6);
        root.add(labeld1,4,7);
        root.add(labele1,4,8);


    }


    public static void labels_green(int string)
    {
        if(string==0)
        {
            labelc1 = new WDynamicLabel(() ->Integer.toString(CONSc));
            labelc1.setColor(color.getArgb_green(),color.getArgb_green());
        }
        else if(string==1)
        {
            labels1 = new WDynamicLabel(() ->Integer.toString(STRc));
            labels1.setColor(color.getArgb_green(),color.getArgb_green());
        }
        else if(string==2)
        {
            labeld1 = new WDynamicLabel(() ->Integer.toString(DEXc));
            labeld1.setColor(color.getArgb_green(),color.getArgb_green());

        }
        else if(string ==3)
        {
            labele1 = new WDynamicLabel(() ->Integer.toString(ENDc));
            labele1.setColor(color.getArgb_green(),color.getArgb_green());
        }
        else {
            int x012=0;
        }



    }

    public static void labels_red(int string)
    {

        if(string==0)
        {
            labelc1 = new WDynamicLabel(() ->Integer.toString(CONSc));
            labelc1.setColor(color.getArgb_custom(1,164,255,164),color.getArgb_custom(1,164,255,164));

        }
        else if(string==1)
        {
            labels1 = new WDynamicLabel(() ->Integer.toString(STRc));
            labels1.setColor(color.getArgb_custom(1,164,255,164),color.getArgb_custom(1,164,255,164));
        }
        else if(string==2)
        {
            labeld1 = new WDynamicLabel(() ->Integer.toString(DEXc));
            labeld1.setColor(color.getArgb_custom(1,164,255,164),color.getArgb_custom(1,164,255,164));

        }
        else if(string ==3)
        {
            labele1 = new WDynamicLabel(() ->Integer.toString(ENDc));
            labele1.setColor(color.getArgb_custom(1,164,255,164),color.getArgb_custom(1,164,255,164));
        }
        else {
            int x012=0;
        }






    }


    public static void labels_wh()
    {
        labelc1 = new WDynamicLabel(() ->Integer.toString(CONSc));
        labelc1.setColor(color.getArgb_custom(1,255,255,255),color.getArgb_custom(1,255,255,255));

        labels1 = new WDynamicLabel(() ->Integer.toString(STRc));
        labels1.setColor(color.getArgb_custom(1,255,255,255),color.getArgb_custom(1,255,255,255));

        labeld1 = new WDynamicLabel(() ->Integer.toString(DEXc));
        labeld1.setColor(color.getArgb_custom(1,255,255,255),color.getArgb_custom(1,255,255,255));

        labele1 = new WDynamicLabel(() ->Integer.toString(ENDc));
        labele1.setColor(color.getArgb_custom(1,255,255,255),color.getArgb_custom(1,255,255,255));
    }

    public static boolean soulmeets()
    {

        if(soulingc>=reqcopy)
        {
            return true;
        }
        return false;
    }

    //SoulData.addNbtPoints(((IEntityDataSaver) MinecraftClient.getInstance().player),1,"Constitution");
    //SoulData.addNbtPoints(((IEntityDataSaver) MinecraftClient.getInstance().player),1,"Strength");
    //SoulData.addNbtPoints(((IEntityDataSaver) MinecraftClient.getInstance().player),1,"dex");

    public static void increase_copy_req(int string)
    {
        if(string==0)
        {
        CONSc++;
        soulingc-=reqcopy;
            levelcopy++;
            reqcopy=levelingsystem.reqcal(levelcopy);
        }
        else if(string==1)
        {
            STRc++;
            levelcopy++;
            reqcopy=levelingsystem.reqcal(levelcopy);
        }
        else if(string==2)
        {
            DEXc++;
            soulingc-=reqcopy;
            levelcopy++;
            reqcopy=levelingsystem.reqcal(levelcopy);
        }
        else if(string==3)
        {
            ENDc++;
            soulingc-=reqcopy;
            levelcopy++;
            reqcopy=levelingsystem.reqcal(levelcopy);
        }
        else
        {
            int do_nothing=0;
        }


    }




    public static boolean decrease(int string)
    {
        if(string==0 &&CONSc>CONS)

        {
            levelcopy--;
            reqcopy=levelingsystem.reqcal(levelcopy);
            CONSc--;
            soulingc+=reqcopy;


            return true;
        }
        else if(string==1&&STRc>STR)
        {
            level--;
            reqcopy=levelingsystem.reqcal(levelcopy);
            STRc--;
            soulingc+=reqcopy;


            return true;
        }
        else if(string==2&&DEXc>DEX)
        {
            level--;
            reqcopy=levelingsystem.reqcal(levelcopy);
            DEXc--;
            soulingc+=reqcopy;


            return true;
        }
        else if(string==3&&ENDc>END)
        {
            level--;
            reqcopy=levelingsystem.reqcal(levelcopy);
            ENDc--;
            soulingc+=reqcopy;


            return true;
        }
        else
        {
            return false;
        }


    }

}
