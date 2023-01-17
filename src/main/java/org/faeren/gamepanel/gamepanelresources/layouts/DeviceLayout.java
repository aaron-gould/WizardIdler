package org.faeren.gamepanel.gamepanelresources.layouts;

import javax.swing.*;
import java.awt.*;

public class DeviceLayout extends JPanel {

    public DeviceLayout(){

        this.setLayout(new GridLayout(0,2,5,0));
        this.setMaximumSize(new Dimension(1000,30));
        this.setOpaque(false);


    }
}
