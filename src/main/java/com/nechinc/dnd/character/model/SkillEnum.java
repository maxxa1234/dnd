package com.nechinc.dnd.character.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SkillEnum {
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
}