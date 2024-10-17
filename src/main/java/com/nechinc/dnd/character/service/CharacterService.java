package com.nechinc.dnd.character.service;

import com.nechinc.dnd.character.Character;
import com.nechinc.dnd.character.model.AbilityScore;
import com.nechinc.dnd.character.model.Skill;
import com.nechinc.dnd.character.util.AbilityModifierUtil;
import com.nechinc.dnd.character.util.ProficiencyBonusUtil;
import com.nechinc.dnd.dice.service.DiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CharacterService {

    private final DiceService diceService;

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

    public int calculateBasicHealth(Character character) {
        int characterMaxHealth = Integer.parseInt(
                character.getCharacterClass().getHealthDice()
                        .substring(1)) + AbilityModifierUtil.getModifier(character.getConstitution());

        character.setMaxHealth(characterMaxHealth);
        character.setCurrentHealth(characterMaxHealth);

        return characterMaxHealth;
    }

    public int changeCurrentHealth(Character character, int value, boolean isAttack) {
        if(isAttack){
            character.setCurrentHealth(character.getMaxHealth() - value);
            return character.getCurrentHealth();
        }
        character.setCurrentHealth(character.getMaxHealth() + value);

        if(character.getCurrentHealth() > character.getMaxHealth()) character.setCurrentHealth(character.getMaxHealth());

        return character.getCurrentHealth();
    }
}
