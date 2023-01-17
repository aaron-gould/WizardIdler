package org.faeren.gamepanel;

import org.faeren.Game;
import org.faeren.gamepanel.gamepanelresources.InvisPanel;
import org.faeren.gamepanel.gametabs.*;
import org.faeren.gamepanel.gametabs.ToolTipTab;

import javax.swing.*;
import java.awt.*;

import static org.faeren.gamepanel.gamepanelresources.Styles.*;

public class GamePanel extends JFrame {

    Game game;

    JMenuBar menuBar = new JMenuBar();
    JMenu file = new JMenu("File");
    public JMenuItem load = new JMenuItem("Load");
    public JMenuItem save = new JMenuItem("Save");
    public JMenuItem exit = new JMenuItem("Exit");

    public ResourceTab resourceTab;
    public DeviceTab deviceTab;
    public UpgradeTab upgradeTab;
    public ToolTipTab toolTipTab;

    public GamePanel(Game game){

        this.game = game;
        deviceTab = new DeviceTab(game);
        upgradeTab = new UpgradeTab(game,this);
        toolTipTab = new ToolTipTab(this, game);
        resourceTab = new ResourceTab(this);


        //adds menu bar
        menuBar.add(file);
        menuBar.setBackground(GOLDISH);
        menuBar.setBorder(BorderFactory.createLineBorder(GOLDISH));
        file.add(load);
        file.add(save);
        file.add(exit);

        //game tabs
        JPanel tabs = new JPanel(new GridLayout(0,3,10,0));

        tabs.setBackground(OFF_BLACK);

        tabs.add(resourceTab);
        tabs.add(deviceTab);
        tabs.add(upgradeTab);

        //JFrame settings
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setJMenuBar(menuBar);
        this.setTitle("Wizard Idler");

        this.getContentPane().setBackground(OFF_BLACK);
        this.setLayout(new BorderLayout());
        this.getContentPane().add(tabs, BorderLayout.CENTER);

        createBorder();

        this.setSize(1200,900);

        this.setVisible(true);

    }

    public void update(){
        this.repaint();
    }

    private void createBorder(){

        InvisPanel top = new InvisPanel();
        this.add(top, BorderLayout.PAGE_START);

        InvisPanel left = new InvisPanel();
        this.add(left, BorderLayout.LINE_START);

        InvisPanel right = new InvisPanel();
        this.add(right, BorderLayout.LINE_END);

        InvisPanel bottom = new InvisPanel();
        this.add(bottom, BorderLayout.PAGE_END);
    }

    public ToolTipTab getToolTipTab(){
        return toolTipTab;
    }

}
