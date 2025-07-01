package com.nechinc.dnd.character.service;

import com.nechinc.dnd.character.model.SkillEnum;
import com.nechinc.dnd.character.model.entity.Character;
import com.nechinc.dnd.character.util.SkillModifierCalculator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CharacterSkillsModifiersCalculatorService {

    private final CharacterService characterService;

    public Map<SkillEnum, Integer> calculateSkillModifiers(UUID id) {
        Character character = characterService.getCharacterById(id);
        return SkillModifierCalculator.calculateSkillModifiers(character);
    }
}
