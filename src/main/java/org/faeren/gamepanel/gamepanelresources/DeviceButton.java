package org.faeren.gamepanel.gamepanelresources;

import javax.swing.*;
import java.awt.*;

public class DeviceButton extends JButton {

    public boolean unlocked;
    public String tooltip;

    public DeviceButton(String text, boolean defaultState){

        this.unlocked = defaultState;

        this.setVisible(unlocked);

        this.setFocusable(false);
        this.setMaximumSize(new Dimension(1000,60));
        this.setText(text);

    }

    public void setTooltip(String tooltip){
        this.tooltip = tooltip;
    }
}
