package org.faeren.gamepanel.gamepanelresources.labels;

import javax.swing.*;

import static org.faeren.gamepanel.gamepanelresources.Styles.*;

public class ToolTipLabel extends JLabel {

    public ToolTipLabel(String label) {
        this();
        this.setText(label);
    }

    public ToolTipLabel() {

        this.setFont(TOOL_TIP_FONT);
        this.setForeground(BRASS);
    }

}
