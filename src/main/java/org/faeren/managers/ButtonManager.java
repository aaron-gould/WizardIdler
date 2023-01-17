package org.faeren.managers;

import org.faeren.Game;
import org.faeren.gamepanel.gametabs.DeviceTab;
import org.faeren.gamepanel.gametabs.ResourceTab;
import org.faeren.gamepanel.gametabs.ToolTipTab;
import org.faeren.gamepanel.gametabs.UpgradeTab;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ButtonManager {

    Game game;
    ToolTipTab toolTipTab;
    ResourceTab resourceTab;
    DeviceTab deviceTab;
    UpgradeTab upgradeTab;
    public ButtonManager(Game game, ToolTipTab toolTipTab, ResourceTab resourceTab, DeviceTab deviceTab, UpgradeTab upgradeTab){

        this.game = game;
        this.toolTipTab = toolTipTab;
        this.resourceTab = resourceTab;
        this.deviceTab = deviceTab;
        this.upgradeTab = upgradeTab;

        //FILE
        saveGameListener();
        loadGameListener();

        //DEVICES
        meditateButtonListener();
        runeButtonListener();
        magicScribeListener();
        chestListener();

        //UPGRADES
        runeMakingButtonListener();
        ancientRunicKnowledgeButtonListener();
        strongerRunesButtonListener();
        chestMakingButtonListener();
    }

    //FILE
    private void saveGameListener(){
        game.gamePanel.save.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e){
                game.saveGame();
            }
        });
    }

    private void loadGameListener(){
        game.gamePanel.load.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e){
                game.loadGame();
            }
        });
    }

    //DEVICES
    private void meditateButtonListener(){
        deviceTab.meditateButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e){
                game.meditate();
            }

            @Override
            public void mouseEntered(MouseEvent e){
                toolTipTab.mouseEnter(true);
                toolTipTab.name.setText("MEDITATE");
                toolTipTab.toolTip.setText("Meditate to gain mana");
            }

            @Override
            public void mouseExited(MouseEvent e){
                toolTipTab.mouseExit();
            }
        }
        );
    }

    private void runeButtonListener(){
        deviceTab.runeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e){
                game.buyRune();
            }

            @Override
            public void mouseEntered(MouseEvent e){
                toolTipTab.mouseEnter(true);
                toolTipTab.name.setText("RUNE");
                toolTipTab.runeLayout.setVisible(true);
                toolTipTab.toolTip.setText("Automatically manifests mana");
            }

            @Override
            public void mouseExited(MouseEvent e){
                toolTipTab.mouseExit();
                toolTipTab.runeLayout.setVisible(false);
            }
        });
    }

    private void magicScribeListener(){
        deviceTab.magicScribeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e){
                game.buyMagicScribe();
            }

            @Override
            public void mouseEntered(MouseEvent e){
                toolTipTab.mouseEnter(true);
                toolTipTab.name.setText("MAGIC SCRIBE");
                toolTipTab.toolTip.setText("Automatically creates books");
                toolTipTab.magicScribeLayout.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e){
                toolTipTab.mouseExit();
                toolTipTab.magicScribeLayout.setVisible(false);
            }
        });
    }
    private void chestListener(){
        deviceTab.chestButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e){
                game.buyChest();
            }

            @Override
            public void mouseEntered(MouseEvent e){
                toolTipTab.mouseEnter(true);
                toolTipTab.name.setText("CHEST");
                toolTipTab.toolTip.setText("Increases your storage capacity");
                toolTipTab.chestLayout.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e){
                toolTipTab.mouseExit();
                toolTipTab.chestLayout.setVisible(false);
            }
        });
    }

    //UPGRADES
    private void runeMakingButtonListener(){
        upgradeTab.runeMaking.button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e){
                if (upgradeTab.runeMaking.button.isEnabled()){
                    game.researchRuneMaking();
                    upgradeTab.runeMaking.visibilityCheck();
                    upgradeTab.innerTab.remove(upgradeTab.runeMaking);

                    toolTipTab.mouseExit();
                    toolTipTab.runeMakingLayout.setVisible(false);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e){
                toolTipTab.mouseEnter(true);
                toolTipTab.name.setText("RUNECRAFT");
                toolTipTab.toolTip.setText("Teaches you the arcane art of Rune Crafting");
                toolTipTab.runeMakingLayout.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e){
                toolTipTab.mouseExit();
                toolTipTab.runeMakingLayout.setVisible(false);
            }
        });
    }

    private void ancientRunicKnowledgeButtonListener(){
        upgradeTab.ancientRunicKnowledge.button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e){
                if (upgradeTab.ancientRunicKnowledge.button.isEnabled()){
                    game.researchAncientRunicKnowledge();
                    upgradeTab.innerTab.remove(upgradeTab.ancientRunicKnowledge);

                    toolTipTab.mouseExit();
                    toolTipTab.ancientRunicKnowledgeLayout.setVisible(false);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e){
                toolTipTab.mouseEnter(true);
                toolTipTab.name.setText("ANCIENT RUNIC KNOWLEDGE");
                toolTipTab.toolTip.setText("Study ancient tomes to enhance your Runes");
                toolTipTab.ancientRunicKnowledgeLayout.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e){
                toolTipTab.mouseExit();
                toolTipTab.ancientRunicKnowledgeLayout.setVisible(false);
            }
        });
    }
    private void strongerRunesButtonListener(){
        upgradeTab.strongerRunes.button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e){
                if (upgradeTab.strongerRunes.button.isEnabled()){
                    game.researchStrongerRunes();
                    upgradeTab.innerTab.remove(upgradeTab.strongerRunes);

                    toolTipTab.mouseExit();
                    toolTipTab.strongerRunesLayout.setVisible(false);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e){
                toolTipTab.mouseEnter(true);
                toolTipTab.name.setText("STRONGER RUNES");
                toolTipTab.toolTip.setText("Even stronger Runes");
                toolTipTab.strongerRunesLayout.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e){
                toolTipTab.mouseExit();
                toolTipTab.strongerRunesLayout.setVisible(false);
            }
        });
    }
    private void chestMakingButtonListener(){
        upgradeTab.chestMaking.button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e){
                if (upgradeTab.chestMaking.button.isEnabled()){
                    game.researchChestMaking();
                    upgradeTab.innerTab.remove(upgradeTab.chestMaking);

                    toolTipTab.mouseExit();
                    toolTipTab.chestMakingLayout.setVisible(false);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e){
                toolTipTab.mouseEnter(false);
                toolTipTab.name.setText("CHESTMAKING");
                toolTipTab.chestMakingLayout.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e){
                toolTipTab.mouseExit();
                toolTipTab.chestMakingLayout.setVisible(false);
            }
        });
    }
}
