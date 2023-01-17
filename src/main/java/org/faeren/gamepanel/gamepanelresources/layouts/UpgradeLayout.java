package org.faeren.gamepanel.gamepanelresources.layouts;

import org.faeren.gamepanel.gamepanelresources.DeviceButton;

import javax.swing.*;
import java.awt.*;

public class UpgradeLayout extends JPanel {

    public DeviceButton button;
    public UpgradeLayout(String text){

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setMaximumSize(new Dimension(1000,35));
        this.setOpaque(false);

        button = new DeviceButton(text, true);
        this.add(button);
        this.add(Box.createVerticalStrut(5));
        button.setAlignmentX(CENTER_ALIGNMENT);
    }


    public void visibilityCheck(){
        this.setVisible(button.isVisible());
    }
}
