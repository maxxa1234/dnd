package com.nechinc.dnd.character.classes;

public enum Class {
    BARBARIAN("d12"),
    BARD("d8"),
    CLERIC("d8"),
    DRUID("d8"),
    FIGHTER("d10"),
    MONK("d8"),
    PALADIN("d10"),
    RANGER("d10"),
    ROGUE("d8"),
    SORCERER("d6"),
    WARLOCK("d8"),
    WIZARD("d6");

    private final String healthDice;

    Class(String healthDice) {
        this.healthDice = healthDice;
    }

    public String getHealthDice() {
        return healthDice;
    }
}
