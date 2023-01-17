package org.faeren.devices;

public class Chest extends Device {

    private double manaStorage = 150;
    private double bookStorage = 5;
    private double crystalStorage = 30;

    public double manaCost;
    final double initManaCost = 150;
    double costMultiplier = 1.2;

    public double getManaStorage(){
        return manaStorage;
    }

    public double getBookStorage(){
        return bookStorage;
    }

    public double getCrystalStorage(){
        return crystalStorage;
    }

    public void setManaCost(){
        manaCost = initManaCost * Math.pow(costMultiplier, numberBuilt);
    }
}
