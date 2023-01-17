package org.faeren.gamepanel.gametabs;

import org.faeren.Game;
import org.faeren.gamepanel.gamepanelresources.DeviceButton;
import org.faeren.gamepanel.gamepanelresources.layouts.DeviceLayout;

import javax.swing.*;
import java.awt.*;

public class DeviceTab extends GameTab {

    Game game;


    public DeviceButton meditateButton = new DeviceButton("Meditate", true);
    public DeviceButton runeButton = new DeviceButton("Rune", false);
    public DeviceButton crystalBallButton = new DeviceButton("Crystal Ball", false);
    public DeviceButton chestButton = new DeviceButton("Chest", false);
    public DeviceButton magicScribeButton = new DeviceButton("Magic Scribe", false);

    public DeviceTab(Game game){
        this.game = game;

        title.setText("Devices");

        DeviceLayout deviceRow1 = new DeviceLayout();
        deviceRow1.add(meditateButton);
        deviceRow1.add(runeButton);
        innerTab.add(deviceRow1);

        innerTab.add(Box.createRigidArea(new Dimension(0,5)));

        DeviceLayout deviceRow2 = new DeviceLayout();
        deviceRow2.add(magicScribeButton);
        deviceRow2.add(chestButton);
        innerTab.add(deviceRow2);
    }

    public void update(){



    }




}
