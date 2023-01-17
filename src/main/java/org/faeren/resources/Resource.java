package org.faeren.resources;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.text.DecimalFormat;

public class Resource {

    final static DecimalFormat df = new DecimalFormat("0.00");

    public double amount;

    private double amountPerSec;
    private double maxAmount;
    public double defaultMaxAmount;
    public Resource(double defaultMaxAmount){
        this.defaultMaxAmount = defaultMaxAmount;
        this.maxAmount = defaultMaxAmount;
    }
    public Resource(){

    }

    public void setAmountPerSec(double generation){
        amountPerSec = generation;
    }

    public void setMaxAmount(double storage){
        maxAmount = storage + defaultMaxAmount;
    }

    @JsonIgnore
    public double getMaxAmount(){
        return maxAmount;
    }
    public void calculateNewAmount(){
        if (amount >= maxAmount || amount + (amountPerSec/50) >= maxAmount){
            amount = maxAmount;
        } else {
            amount += (amountPerSec/50);
        }
    }

    public String displayAmount(){
        return df.format(amount);
    }
    public String displayMaxAmount(){
        return df.format(maxAmount);
    }

    public String displayAmountPerSec(){
        return df.format(amountPerSec);
    }
}
