package com.nechinc.dnd.character.constant;

import java.util.HashMap;
import java.util.Map;

public class HealthConst {
    public static Map<String, String> getHealthDiceByClass(){
        Map<String, String> healthDices = new HashMap<>();

        healthDices.put("barbarian", "d12");
        healthDices.put("bard", "d8");
        healthDices.put("cleric", "d8");
        healthDices.put("druid", "d8");
        healthDices.put("fighter", "d10");
        healthDices.put("monk", "d8");
        healthDices.put("paladin", "d10");
        healthDices.put("ranger", "d10");
        healthDices.put("rogue", "d8");
        healthDices.put("sorcerer", "d6");
        healthDices.put("warlock", "d8");
        healthDices.put("wizard", "d6");

        return healthDices;
    }
}
