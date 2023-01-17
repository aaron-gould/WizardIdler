package org.faeren.gamepanel.gamepanelresources.layouts;

import javax.swing.*;
import java.awt.*;

public class ResourceLayout extends JPanel {

    public ResourceLayout(){

        this.setLayout(new GridLayout(0,3));
        this.setMaximumSize(new Dimension(1000,30));
        this.setOpaque(false);
    }
}
