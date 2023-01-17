package org.faeren.devices;

public class MagicScribe extends Device {

    double initManaCost = 100;
    double costMultiplier = 1.15;
    public double manaCost;
    public double bookGeneration = 0.05;
    public void setManaCost(){
        manaCost = initManaCost * Math.pow(costMultiplier, numberBuilt);
    }
    public String displayManaCost(){
        return df.format(manaCost);
    }
}
