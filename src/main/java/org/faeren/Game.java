package org.faeren;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.faeren.devices.*;
import org.faeren.gamepanel.GamePanel;
import org.faeren.managers.ButtonManager;
import org.faeren.managers.ResourceManager;
import org.faeren.managers.SaveManager;
import org.faeren.resources.Resource;
import org.faeren.upgrades.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Game {

    public GamePanel gamePanel = new GamePanel(this);

    //RESOURCES
    public Resource mana = new Resource(500);
    public Resource books = new Resource(250);
    public Resource crystals = new Resource(50);

    //DEVICES
    public Rune rune = new Rune();
    public MagicScribe magicScribe = new MagicScribe();
    public Chest chest = new Chest();
    public CrystalBall crystalBall = new CrystalBall();

    //UPGRADES
    public RuneMaking runeMaking = new RuneMaking();
    public AncientRunicKnowledge ancientRunicKnowledge = new AncientRunicKnowledge();
    public StrongerRunes strongerRunes = new StrongerRunes();
    public ChestMaking chestMaking = new ChestMaking();

    //MANAGERS
    ResourceManager resourceManager = new ResourceManager(this,
        this.gamePanel.getToolTipTab(),
        this.gamePanel.resourceTab,
        this.gamePanel.deviceTab,
        this.gamePanel.upgradeTab);
    ButtonManager buttonManager = new ButtonManager(this,
        this.gamePanel.getToolTipTab(),
        this.gamePanel.resourceTab,
        this.gamePanel.deviceTab,
        this.gamePanel.upgradeTab);
    SaveManager saveManager;
    static ObjectMapper objectMapper = new ObjectMapper();
    List<Resource> resourceList;
    List<Device> deviceList;
    List<Upgrades> upgradesList;

    //CORE MECHANICS
    public void tick(){
        resourceManager.updateResources();
        resourceManager.updateResourceTab();
        resourceManager.updateToolTipTab();
        resourceManager.updateDeviceAmounts();
        resourceManager.setDeviceVisibility();
        resourceManager.setUpgradeVisibility();
        resourceManager.setButtonEnabled();
        gamePanel.update();
    }
    public void saveGame(){

        resourceList = new ArrayList<>();
        resourceList.add(mana);
        resourceList.add(books);
        resourceList.add(crystals);

        deviceList = new ArrayList<>();
        deviceList.add(rune);
        deviceList.add(magicScribe);
        deviceList.add(crystalBall);
        deviceList.add(chest);

        upgradesList = new ArrayList<>();
        upgradesList.add(runeMaking);
        upgradesList.add(ancientRunicKnowledge);
        upgradesList.add(strongerRunes);
        upgradesList.add(chestMaking);
        saveManager = new SaveManager(resourceList, deviceList, upgradesList);

        try{
            objectMapper.writeValue(new File("C:\\Users\\Aaron\\Java Projects\\WizardIdler\\target\\gamedata.json"), saveManager);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void loadGame(){
        try {
            saveManager = objectMapper.readValue(new File("C:\\Users\\Aaron\\Java Projects\\WizardIdler\\target\\gamedata.json"), SaveManager.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        mana = saveManager.resources().get(0);
        books = saveManager.resources().get(1);
        crystals = saveManager.resources().get(2);

        rune = (Rune) saveManager.devices().get(0);
        magicScribe = (MagicScribe) saveManager.devices().get(1);
        crystalBall = (CrystalBall) saveManager.devices().get(2);
        chest = (Chest) saveManager.devices().get(3);

        runeMaking = (RuneMaking) saveManager.upgrades().get(0);
        ancientRunicKnowledge = (AncientRunicKnowledge) saveManager.upgrades().get(1);
        strongerRunes = (StrongerRunes) saveManager.upgrades().get(2);
        chestMaking = (ChestMaking) saveManager.upgrades().get(3);

        validateUpgradeTab();
    }

    //DEVICES

    public void meditate(){
        if (mana.amount < mana.getMaxAmount()){
            mana.amount++;
        }
    }
    public void buyRune(){
        if (gamePanel.deviceTab.runeButton.isEnabled()){
            mana.amount -= rune.manaCost;
            rune.build();
            rune.setManaCost();
        }
    }
    public void buyMagicScribe(){
        if (gamePanel.deviceTab.magicScribeButton.isEnabled()){
            mana.amount -= magicScribe.manaCost;
            magicScribe.build();
            magicScribe.setManaCost();
        }
    }
    public void buyChest(){
        if (gamePanel.deviceTab.chestButton.isEnabled()){
            mana.amount -= chest.manaCost;
            chest.build();
            chest.setManaCost();
        }
    }
    //UPGRADES

    private void validateUpgradeTab(){
        if (runeMaking.researched){
            gamePanel.upgradeTab.remove(gamePanel.upgradeTab.runeMaking);
        }
    }
    public void researchRuneMaking(){
        mana.amount -= runeMaking.manaCost;
        runeMaking.research();
    }
    public void researchAncientRunicKnowledge(){
        mana.amount -= ancientRunicKnowledge.manaCost;
        books.amount -= ancientRunicKnowledge.bookCost;
        ancientRunicKnowledge.research();
    }
    public void researchStrongerRunes(){
        mana.amount -= strongerRunes.manaCost;
        books.amount -= strongerRunes.bookCost;
        strongerRunes.research();
    }
    public void researchChestMaking(){
        books.amount -= chestMaking.bookCost;
        chestMaking.research();
    }

}
