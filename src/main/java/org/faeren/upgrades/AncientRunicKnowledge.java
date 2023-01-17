package org.faeren.upgrades;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AncientRunicKnowledge extends Upgrades {

    public final double manaCost = 150;
    public final double bookCost = 10;
    final double manaGenerationMultiplier = 2;

    @JsonIgnore
    public double getMultiplier(){
        if (this.researched){
            return manaGenerationMultiplier;
        } else {
            return 1;
        }
    }
}
