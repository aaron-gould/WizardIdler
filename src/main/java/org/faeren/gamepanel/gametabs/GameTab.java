package org.faeren.gamepanel.gametabs;

import org.faeren.gamepanel.gamepanelresources.InvisPanel;
import org.faeren.gamepanel.gamepanelresources.labels.TitleLabel;
import org.faeren.gamepanel.gamepanelresources.layouts.TabTitleLayout;

import javax.swing.*;

import java.awt.*;

import static org.faeren.gamepanel.gamepanelresources.Styles.*;

public abstract class GameTab extends JPanel {
    public InvisPanel innerTab = new InvisPanel();
    protected TitleLabel title = new TitleLabel();
    protected TabTitleLayout titleLayout = new TabTitleLayout();

    public GameTab(){

        //sets layout for all game tabs, with margins on the sides

        InvisPanel left = new InvisPanel();
        InvisPanel right = new InvisPanel();

        this.setLayout(new BorderLayout());
        this.add(innerTab, BorderLayout.CENTER);
        this.add(left, BorderLayout.LINE_START);
        this.add(right, BorderLayout.LINE_END);
        this.setBackground(OFF_BLACK);
        this.setBorder(BorderFactory.createDashedBorder(GOLDISH,1,3));

        //innerTab is the usable/functional panel
        innerTab.setLayout(new BoxLayout(innerTab, BoxLayout.PAGE_AXIS));

        //title needs to be set for each subclass
        titleLayout.add(title);
        innerTab.add(titleLayout);

    }

}
