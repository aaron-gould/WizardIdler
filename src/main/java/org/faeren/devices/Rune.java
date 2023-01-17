package org.faeren.devices;

public class Rune extends Device {

    double initManaCost = 5;
    double costMultiplier = 1.2;
    public double manaCost;
    public double manaGeneration = 0.2;

    public void setManaCost(){
        manaCost = initManaCost * Math.pow(costMultiplier, numberBuilt);
    }

    public String displayManaCost(){
        return df.format(manaCost);
    }


}
