package org.faeren.gamepanel.gametabs;

import org.faeren.Game;
import org.faeren.gamepanel.GamePanel;
import org.faeren.gamepanel.gamepanelresources.layouts.UpgradeLayout;

import java.util.ArrayList;

public class UpgradeTab extends GameTab {

    GamePanel gamePanel;
    Game game;
    public ArrayList<UpgradeLayout> buttons = new ArrayList<>();
    public UpgradeLayout runeMaking = new UpgradeLayout("Runecraft");
    public UpgradeLayout ancientRunicKnowledge = new UpgradeLayout("Ancient Runic Knowledge");
    public UpgradeLayout strongerRunes = new UpgradeLayout("Stronger Runes");
    public UpgradeLayout chestMaking = new UpgradeLayout("Chestcraft");

    public UpgradeTab(Game game, GamePanel gamePanel){

        title.setText("Upgrades");
        this.gamePanel = gamePanel;
        this.game = game;

        innerTab.add(titleLayout);

        addButtonsToList();
        createInnerTab();

    }

    public void createInnerTab(){
        for (UpgradeLayout layout : buttons){
            innerTab.add(layout);
            layout.setVisible(false);
        }
        gamePanel.repaint();
        runeMaking.setVisible(true);
    }

    private void addButtonsToList(){
        buttons.add(runeMaking);
        buttons.add(ancientRunicKnowledge);
        buttons.add(chestMaking);
        buttons.add(strongerRunes);
    }

}
