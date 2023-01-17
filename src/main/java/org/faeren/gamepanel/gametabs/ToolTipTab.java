package org.faeren.gamepanel.gametabs;

import org.faeren.Game;
import org.faeren.gamepanel.GamePanel;
import org.faeren.gamepanel.gamepanelresources.labels.ResourceLabel;
import org.faeren.gamepanel.gamepanelresources.labels.ToolTipLabel;
import org.faeren.gamepanel.gamepanelresources.layouts.HoverLayout;

import javax.swing.*;
import java.awt.*;

import static org.faeren.gamepanel.gamepanelresources.Styles.*;

public class ToolTipTab extends GameTab {

    GamePanel gamePanel;
    Game game;

    public ResourceLabel name = new ResourceLabel();

    public ToolTipLabel toolTip = new ToolTipLabel();

    //DEVICES
    public HoverLayout runeLayout;
    public HoverLayout magicScribeLayout;
    public HoverLayout crystalBallLayout;
    public HoverLayout chestLayout;

    //UPGRADES
    public HoverLayout runeMakingLayout;
    public HoverLayout ancientRunicKnowledgeLayout;
    public HoverLayout strongerRunesLayout;
    public HoverLayout chestMakingLayout;

    public ToolTipTab(GamePanel gamePanel, Game game){
        this.gamePanel = gamePanel;
        this.game = game;

        this.setBackground(OFF_BLACK);
        this.setBorder(BorderFactory.createLineBorder(GOLDISH));
        this.setMaximumSize(new Dimension(1000,200));
        this.setVisible(false);

        titleLayout.setLayout(new FlowLayout(FlowLayout.CENTER));
        titleLayout.remove(title);
        titleLayout.add(name);
        innerTab.add(titleLayout);

        //DEVICES
        innerTab.add(createRuneLayout());
        innerTab.add(createMagicScribeLayout());
        innerTab.add(createCrystalBallLayout());
        innerTab.add(createChestLayout());

        //UPGRADES
        innerTab.add(createRuneMakingLayout());
        innerTab.add(createAncientRunicKnowledgeLayout());
        innerTab.add(createStrongerRunesLayout());
        innerTab.add(createChestMakingLayout());

        toolTip.setAlignmentX(CENTER_ALIGNMENT);
        innerTab.add(toolTip);
        innerTab.add(Box.createVerticalStrut(5));
    }

    //TOOLTIP MECHANICS

    public void mouseEnter(boolean hasToolTip){
        this.setVisible(true);
        toolTip.setVisible(hasToolTip);
    }
    public void mouseExit(){
        this.setVisible(false);
        toolTip.setVisible(false);
    }
    //DEVICES

    private HoverLayout createRuneLayout(){
        runeLayout = new HoverLayout();
        runeLayout.setResourceType("MANA");
        runeLayout.setVisible(false);
        return runeLayout;
    }
    private HoverLayout createMagicScribeLayout(){
        magicScribeLayout = new HoverLayout();
        magicScribeLayout.setResourceType("MANA");
        magicScribeLayout.setVisible(false);
        return magicScribeLayout;
    }
    private HoverLayout createCrystalBallLayout(){
        crystalBallLayout = new HoverLayout();
        crystalBallLayout.setResourceType("MANA");
        crystalBallLayout.setVisible(false);
        return crystalBallLayout;
    }
    private HoverLayout createChestLayout(){
        chestLayout = new HoverLayout();
        chestLayout.setResourceType("BOOKS");
        chestLayout.setVisible(false);
        return chestLayout;
    }

    //UPGRADES
    private HoverLayout createRuneMakingLayout(){
        runeMakingLayout = new HoverLayout();
        runeMakingLayout.setResourceType("MANA");
        runeMakingLayout.setResourceCost("5.00");
        runeMakingLayout.setVisible(false);
        return runeMakingLayout;
    }
    private HoverLayout createAncientRunicKnowledgeLayout(){
        ancientRunicKnowledgeLayout = new HoverLayout();
        ancientRunicKnowledgeLayout.setResourceType("MANA", "BOOKS");
        ancientRunicKnowledgeLayout.setResourceCost("150.00", "10.00");
        ancientRunicKnowledgeLayout.setVisible(false);
        return ancientRunicKnowledgeLayout;
    }
    private HoverLayout createStrongerRunesLayout(){
        strongerRunesLayout = new HoverLayout();
        strongerRunesLayout.setResourceType("MANA", "BOOKS");
        strongerRunesLayout.setResourceCost("1000", "30");
        strongerRunesLayout.setVisible(false);
        return strongerRunesLayout;
    }
    private HoverLayout createChestMakingLayout(){
        chestMakingLayout = new HoverLayout();
        chestMakingLayout.setResourceType("BOOKS");
        chestMakingLayout.setResourceCost("20");
        chestMakingLayout.setVisible(false);
        return chestMakingLayout;
    }
}
