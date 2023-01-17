package org.faeren.gamepanel.gametabs;

import org.faeren.gamepanel.GamePanel;
import org.faeren.gamepanel.gamepanelresources.labels.AmountLabel;
import org.faeren.gamepanel.gamepanelresources.labels.AmountPerSecLabel;
import org.faeren.gamepanel.gamepanelresources.labels.ResourceLabel;
import org.faeren.gamepanel.gamepanelresources.layouts.ResourceLayout;

import javax.swing.*;

public class ResourceTab extends GameTab {

    GamePanel gamePanel;

    //MANA
    public ResourceLabel mana = new ResourceLabel("MANA");
    public AmountLabel manaAmount = new AmountLabel();
    public AmountPerSecLabel manaAmountPerSec = new AmountPerSecLabel();

    //CRYSTALS
    public ResourceLabel crystals = new ResourceLabel("CRYSTALS");
    public AmountLabel crystalsAmount = new AmountLabel();
    public AmountLabel crystalsAmountPerSec = new AmountLabel();

    //BOOKS
    public ResourceLabel books = new ResourceLabel("BOOKS");
    public AmountLabel booksAmount = new AmountLabel();
    public AmountLabel booksAmountPerSec = new AmountLabel();
    public ResourceTab(GamePanel gamePanel){

        this.gamePanel = gamePanel;

        title.setText("Resources");

        ResourceLayout manaLayout = new ResourceLayout();
        manaLayout.add(mana);
        manaLayout.add(manaAmount);
        manaLayout.add(manaAmountPerSec);
        innerTab.add(manaLayout);

        ResourceLayout bookLayout = new ResourceLayout();
        bookLayout.add(books);
        bookLayout.add(booksAmount);
        bookLayout.add(booksAmountPerSec);
        innerTab.add(bookLayout);

        ResourceLayout crystalLayout = new ResourceLayout();
        crystalLayout.add(crystals);
        crystalLayout.add(crystalsAmount);
        crystalLayout.add(crystalsAmountPerSec);
        innerTab.add(crystalLayout);

        innerTab.add(Box.createVerticalGlue());

        innerTab.add(gamePanel.getToolTipTab());

        innerTab.add(Box.createVerticalStrut(8));
    }

}
