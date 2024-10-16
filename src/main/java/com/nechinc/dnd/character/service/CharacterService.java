package com.nechinc.dnd.character.service;

import com.nechinc.dnd.character.Character;
import com.nechinc.dnd.character.constant.HealthConst;
import com.nechinc.dnd.character.model.AbilityScore;
import com.nechinc.dnd.character.model.Skill;
import com.nechinc.dnd.character.util.AbilityModifierUtil;
import com.nechinc.dnd.character.util.ProficiencyBonusUtil;
import com.nechinc.dnd.dice.model.Dice;
import com.nechinc.dnd.dice.model.DiceRequest;
import com.nechinc.dnd.dice.service.DiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
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

    public int calculateCharacterMaxHealth(Character character) {
        int characterMaxHealth = 0;
        String characterHealthDiceByClass = HealthConst.getHealthDiceByClass().get(character.getCharacterClass());

        if(character.getLevel() == 1) {
            characterMaxHealth = Integer.parseInt(
                    characterHealthDiceByClass
                            .substring(1)) + character.getConstitution();
            character.setMaxHealth(characterMaxHealth);
            return characterMaxHealth;
        }

        int constantBonus = calculateConstantBonus(character);

        for (int i = 0; i < character.getLevel()-1; i++) {
            characterMaxHealth += diceService.calculateValueOfDice(
                    new DiceRequest(
                            List.of(
                                    new Dice(characterHealthDiceByClass)), 1)).getSum();
        }
        characterMaxHealth += constantBonus;

        character.setMaxHealth(characterMaxHealth);
        return characterMaxHealth;

    }
    private int calculateConstantBonus(Character character){
        int maxHealthDiceValue = Integer.parseInt(
                HealthConst.getHealthDiceByClass()
                        .get(character.getCharacterClass()).substring(1));
        return maxHealthDiceValue + (character.getLevel() * character.getConstitution());
    }
}
