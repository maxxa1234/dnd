package com.nechinc.dnd.character.util;

import com.nechinc.dnd.character.model.SkillEnum;
import com.nechinc.dnd.character.model.entity.Character;
import com.nechinc.dnd.character.model.AbilityScore;

import java.util.HashMap;
import java.util.Map;

public class SkillModifierCalculator {

    public static Map<SkillEnum, Integer> calculateSkillModifiers(Character character) {
        Map<SkillEnum, Integer> skillModifiers = new HashMap<>();

        int proficiencyBonus = ProficiencyBonusUtil.getProficiencyBonus(character.getLevel());

        for (SkillEnum skillEnum : SkillEnum.values()) {
            int abilityScore = getAbilityScore(character, skillEnum.getAbilityScore());

            int skillModifier = AbilityModifierUtil.getModifier(abilityScore);

            if (character.getSelectedClassSkills().contains(skillEnum)) {
                skillModifier += proficiencyBonus;
            }

            skillModifiers.put(skillEnum, skillModifier);
        }

        return skillModifiers;
    }

    private static int getAbilityScore(Character character, AbilityScore abilityScore) {
        return switch (abilityScore) {
            case STRENGTH -> character.getStrength();
            case DEXTERITY -> character.getDexterity();
            case CONSTITUTION -> character.getConstitution();
            case INTELLIGENCE -> character.getIntelligence();
            case WISDOM -> character.getWisdom();
            case CHARISMA -> character.getCharisma();
        };
    }
}
