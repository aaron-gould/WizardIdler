package org.faeren.devices;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.text.DecimalFormat;
@JsonTypeInfo( use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Rune.class, name = "rune"),
        @JsonSubTypes.Type(value = MagicScribe.class, name = "magicScribe"),
        @JsonSubTypes.Type(value = CrystalBall.class, name = "crystalBall"),
        @JsonSubTypes.Type(value = Chest.class, name = "chest")
})

public abstract class Device {

    final static DecimalFormat df = new DecimalFormat("0.00");
    public int numberBuilt;

    public void build(){
        numberBuilt++;
    }
    public String display(double number){
        return df.format(number);
    }
}
