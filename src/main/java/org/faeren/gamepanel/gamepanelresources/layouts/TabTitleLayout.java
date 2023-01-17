package org.faeren.gamepanel.gamepanelresources.layouts;

import javax.swing.*;
import java.awt.*;

public class TabTitleLayout extends JPanel {

    public TabTitleLayout(){

        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setMaximumSize(new Dimension(1000,60));
        this.setOpaque(false);
    }
}
