package org.faeren.gamepanel.gamepanelresources.labels;

import javax.swing.*;

import static org.faeren.gamepanel.gamepanelresources.Styles.*;

public class ResourceLabel extends JLabel {

    public ResourceLabel(){

        this.setFont(RESOURCE_FONT);
        this.setForeground(GOLDISH);
    }

    public ResourceLabel(String label){

        this();
        this.setText(label);
    }
}
