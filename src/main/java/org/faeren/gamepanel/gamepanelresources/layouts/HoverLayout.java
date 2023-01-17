package org.faeren.gamepanel.gamepanelresources.layouts;

import org.faeren.gamepanel.gamepanelresources.labels.ResourceLabel;

import javax.swing.*;
import java.awt.*;

public class HoverLayout extends JPanel {

    private ResourceLabel resourceType;
    private ResourceLabel resourceCost;
    private ResourceLabel resourceType1;
    private ResourceLabel resourceCost1;
    private ResourceLabel resourceType2;
    private ResourceLabel resourceCost2;

    public HoverLayout(){

        this.setLayout(new GridLayout(0,2));
        this.setMaximumSize(new Dimension(1000,30));
        this.setOpaque(false);

        resourceType = new ResourceLabel();
        resourceCost = new ResourceLabel();
        add(this.resourceType);
        add(this.resourceCost);

    }


    public void setResourceType(String resourceType){
        this.resourceType.setText(resourceType);
    }
    public void setResourceType(String resourceType, String resourceType1){
        this.resourceType1 = new ResourceLabel();
        this.resourceCost1 = new ResourceLabel();
        add(this.resourceType1);
        add(this.resourceCost1);

        this.setResourceType(resourceType);
        this.resourceType1.setText(resourceType1);
    }
    public void setResourceType(String resourceType, String resourceType1, String resourceType2){
        this.resourceType2 = new ResourceLabel();
        this.resourceCost2 = new ResourceLabel();
        add(this.resourceType2);
        add(this.resourceCost2);

        this.setResourceType(resourceType, resourceType1);
        this.resourceType2.setText(resourceType2);
    }

    public void setResourceCost(String resourceCost){
        this.resourceCost.setText(resourceCost);
        this.resourceCost.setHorizontalAlignment(SwingConstants.RIGHT);
    }
    public void setResourceCost(String resourceCost, String resourceCost1){
    this.setResourceCost(resourceCost);
    this.resourceCost1.setText(resourceCost1);
    this.resourceCost1.setHorizontalAlignment(SwingConstants.RIGHT);
    }
    public void setResourceCost(String resourceCost, String resourceCost1, String resourceCost2){
    this.setResourceCost(resourceCost, resourceCost1);
    this.resourceCost2.setText(resourceCost2);
    this.resourceCost2.setHorizontalAlignment(SwingConstants.RIGHT);
    }

}
