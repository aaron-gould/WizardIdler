package org.faeren.managers;

import org.faeren.Game;
import org.faeren.gamepanel.gametabs.DeviceTab;
import org.faeren.gamepanel.gametabs.ResourceTab;
import org.faeren.gamepanel.gametabs.ToolTipTab;
import org.faeren.gamepanel.gametabs.UpgradeTab;

public class ResourceManager {

    Game game;
    ToolTipTab toolTipTab;
    ResourceTab resourceTab;
    DeviceTab deviceTab;
    UpgradeTab upgradeTab;

    public ResourceManager(Game game, ToolTipTab toolTipTab, ResourceTab resourceTab, DeviceTab deviceTab, UpgradeTab upgradeTab){
        this.game = game;
        this.toolTipTab = toolTipTab;
        this.resourceTab = resourceTab;
        this.deviceTab = deviceTab;
        this.upgradeTab = upgradeTab;

        setDeviceCosts();

    }

    //RESOURCES
    public void updateResources(){

        //MANA
        game.mana.setMaxAmount(
                game.chest.getManaStorage() * game.chest.numberBuilt);
        game.mana.setAmountPerSec(
                game.rune.numberBuilt *
                game.rune.manaGeneration *
                game.ancientRunicKnowledge.getMultiplier() *
                game.strongerRunes.getMultiplier());
        game.mana.calculateNewAmount();

        //BOOKS
        game.books.setMaxAmount(
                game.chest.getBookStorage() * game.chest.numberBuilt);
        game.books.setAmountPerSec(
                game.magicScribe.numberBuilt * game.magicScribe.bookGeneration);
        game.books.calculateNewAmount();

        //CRYSTALS
        game.crystals.setMaxAmount(
                game.chest.getCrystalStorage() * game.chest.numberBuilt);
        game.crystals.setAmountPerSec(0);
        game.crystals.calculateNewAmount();
    }
    public void updateResourceTab(){

        //MANA
        resourceTab.manaAmount.setText(game.mana.displayAmount() + "/" + game.mana.displayMaxAmount());
        resourceTab.manaAmountPerSec.setText(game.mana.displayAmountPerSec() + "/sec");

        //BOOKS
        resourceTab.booksAmount.setText(game.books.displayAmount() + "/" + game.books.displayMaxAmount());
        resourceTab.booksAmountPerSec.setText(game.books.displayAmountPerSec() + "/sec");

        //CRYSTALS
        resourceTab.crystalsAmount.setText(game.crystals.displayAmount() + "/" + game.crystals.displayMaxAmount());
        resourceTab.crystalsAmountPerSec.setText(game.crystals.displayAmountPerSec() + "/sec");
    }

    public void setButtonEnabled() {

        //checks to see if button should be enabled
        //RUNE DEVICE
        if (game.mana.amount >= game.rune.manaCost){
            deviceTab.runeButton.setEnabled(true);
        } else {
            deviceTab.runeButton.setEnabled(false);
        }

        //MAGIC SCRIBE DEVICE
        if (game.mana.amount >= game.magicScribe.manaCost){
            deviceTab.magicScribeButton.setEnabled(true);
        } else {
            deviceTab.magicScribeButton.setEnabled(false);
        }

        //CHEST DEVICE
        if (game.mana.amount >= game.chest.manaCost){
            deviceTab.chestButton.setEnabled(true);
        } else {
            deviceTab.chestButton.setEnabled(false);
        }

        //RUNE MAKING UPGRADE
        if (game.mana.amount >= game.runeMaking.manaCost) {
            upgradeTab.runeMaking.button.setEnabled(true);
        } else {
            upgradeTab.runeMaking.button.setEnabled(false);
        }

        //ANCIENT RUNIC KNOWLEDGE UPGRADE
        if (game.mana.amount >= game.ancientRunicKnowledge.manaCost &&
              game.books.amount >= game.ancientRunicKnowledge.bookCost){
            upgradeTab.ancientRunicKnowledge.button.setEnabled(true);
        } else {
            upgradeTab.ancientRunicKnowledge.button.setEnabled(false);
        }

        //STRONGER RUNES UPGRADE
        if (game.mana.amount >= game.strongerRunes.manaCost &&
              game.books.amount >= game.strongerRunes.bookCost){
            upgradeTab.strongerRunes.button.setEnabled(true);
        } else {
            upgradeTab.strongerRunes.button.setEnabled(false);
        }

        //CHEST MAKING UPGRADE
        if (game.books.amount >= game.chestMaking.bookCost){
            upgradeTab.chestMaking.button.setEnabled(true);
        } else {
            upgradeTab.chestMaking.button.setEnabled(false);
        }
    }

    //DEVICES
    private void setDeviceCosts(){
        game.rune.setManaCost();
        game.magicScribe.setManaCost();
        game.chest.setManaCost();
    }
    public void updateDeviceAmounts(){
           if (game.rune.numberBuilt > 0){
            deviceTab.runeButton.setText("Rune (" + game.rune.numberBuilt + ")");
        }
            if (game.magicScribe.numberBuilt > 0){
            deviceTab.magicScribeButton.setText("Magic Scribe (" + game.magicScribe.numberBuilt + ")");
        }
            if (game.chest.numberBuilt > 0){
            deviceTab.chestButton.setText("Chest (" + game.chest.numberBuilt + ")");
        }
    }
    public void setDeviceVisibility(){
        if (game.mana.amount >= 50){
            deviceTab.magicScribeButton.setVisible(true);
        }

    }

    //UPGRADES
    public void setUpgradeVisibility(){

        //RUNE MAKING
        if (game.runeMaking.researched){
            upgradeTab.runeMaking.setVisible(false);
            deviceTab.runeButton.setVisible(true);
            upgradeTab.ancientRunicKnowledge.setVisible(true);
            upgradeTab.chestMaking.setVisible(true);
        }

        //ANCIENT RUNIC KNOWLEDGE
        if (game.ancientRunicKnowledge.researched){
            upgradeTab.ancientRunicKnowledge.setVisible(false);
            upgradeTab.strongerRunes.setVisible(true);
        }

        //STRONGER RUNES
        if (game.strongerRunes.researched){
            upgradeTab.strongerRunes.setVisible(false);
        }

        //CHEST MAKING
        if (game.chestMaking.researched){
            upgradeTab.chestMaking.setVisible(false);
            deviceTab.chestButton.setVisible(true);
        }
    }

    //TOOLTIP
    public void updateToolTipTab(){
        toolTipTab.runeLayout.setResourceCost(game.rune.displayManaCost());
        toolTipTab.magicScribeLayout.setResourceCost(game.magicScribe.displayManaCost());
        toolTipTab.chestLayout.setResourceCost(game.chest.display(game.chest.manaCost));
    }
}
