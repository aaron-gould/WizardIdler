package org.faeren.upgrades;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo( use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = RuneMaking.class, name = "runeMaking"),
        @JsonSubTypes.Type(value = AncientRunicKnowledge.class, name = "ancientRunicKnowledge"),
        @JsonSubTypes.Type(value = StrongerRunes.class, name = "strongerRunes"),
        @JsonSubTypes.Type(value = ChestMaking.class, name = "chestMaking")
})

public abstract class Upgrades {

    public boolean researched = false;

    public void research(){
        researched = true;
    }
}
