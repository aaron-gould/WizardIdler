package org.faeren.upgrades;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class StrongerRunes extends Upgrades {
    public double manaCost = 1000;
    public double bookCost = 30;
    final double manaGenerationMultiplier = 1.2;

    @JsonIgnore
    public double getMultiplier(){
        if (this.researched){
            return manaGenerationMultiplier;
        } else {
            return 1;
        }
    }
}
