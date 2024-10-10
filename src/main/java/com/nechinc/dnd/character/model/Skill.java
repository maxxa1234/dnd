package com.nechinc.dnd.character.model;

public enum Skill {
    ATHLETICS(AbilityScore.STRENGTH),
    ACROBATICS(AbilityScore.DEXTERITY),
    SLEIGHT_OF_HAND(AbilityScore.DEXTERITY),
    STEALTH(AbilityScore.DEXTERITY),
    ARCANA(AbilityScore.INTELLIGENCE),
    HISTORY(AbilityScore.INTELLIGENCE),
    INVESTIGATION(AbilityScore.INTELLIGENCE),
    NATURE(AbilityScore.INTELLIGENCE),
    RELIGION(AbilityScore.INTELLIGENCE),
    ANIMAL_HANDLING(AbilityScore.WISDOM),
    INSIGHT(AbilityScore.WISDOM),
    MEDICINE(AbilityScore.WISDOM),
    PERCEPTION(AbilityScore.WISDOM),
    SURVIVAL(AbilityScore.WISDOM),
    DECEPTION(AbilityScore.CHARISMA),
    INTIMIDATION(AbilityScore.CHARISMA),
    PERFORMANCE(AbilityScore.CHARISMA),
    PERSUASION(AbilityScore.CHARISMA);

    private final AbilityScore abilityScore;

    Skill(AbilityScore abilityScore) {
        this.abilityScore = abilityScore;
    }

    public AbilityScore getAbilityScore() {
        return abilityScore;
    }
}
