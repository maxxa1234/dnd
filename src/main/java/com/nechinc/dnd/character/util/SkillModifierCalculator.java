package com.nechinc.dnd.character.util;

import com.nechinc.dnd.character.model.entity.Character;
import com.nechinc.dnd.character.model.AbilityScore;
import com.nechinc.dnd.character.model.Skill;

import java.util.HashMap;
import java.util.Map;

public class SkillModifierCalculator {

    public static Map<Skill, Integer> calculateSkillModifiers(Character character) {
        Map<Skill, Integer> skillModifiers = new HashMap<>();

        int proficiencyBonus = ProficiencyBonusUtil.getProficiencyBonus(character.getLevel());

        for (Skill skill : Skill.values()) {
            int abilityScore = getAbilityScore(character, skill.getAbilityScore());

            int skillModifier = AbilityModifierUtil.getModifier(abilityScore);

            if (character.getSkillProficiencies() != null && character.getSkillProficiencies().contains(skill)) {
                skillModifier += proficiencyBonus;
            }

            skillModifiers.put(skill, skillModifier);
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
