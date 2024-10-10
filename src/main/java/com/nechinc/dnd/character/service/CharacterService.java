package com.nechinc.dnd.character.service;

import com.nechinc.dnd.character.Character;
import com.nechinc.dnd.character.model.AbilityScore;
import com.nechinc.dnd.character.model.Skill;
import com.nechinc.dnd.character.util.AbilityModifierUtil;
import com.nechinc.dnd.character.util.ProficiencyBonusUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CharacterService {
    public Map<Skill, Integer> calculateSkillModifiers(Character character) {
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

    private int getAbilityScore(Character character, AbilityScore abilityScore) {
        switch (abilityScore) {
            case STRENGTH:
                return character.getStrength();
            case DEXTERITY:
                return character.getDexterity();
            case CONSTITUTION:
                return character.getConstitution();
            case INTELLIGENCE:
                return character.getIntelligence();
            case WISDOM:
                return character.getWisdom();
            case CHARISMA:
                return character.getCharisma();
            default:
                return 10;
        }
    }
}
