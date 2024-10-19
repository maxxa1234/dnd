package com.nechinc.dnd.character.service;

import com.nechinc.dnd.character.constant.SkillConst;
import com.nechinc.dnd.character.model.Skill;
import com.nechinc.dnd.character.model.dto.ClassMasteryDto;
import com.nechinc.dnd.character.model.entity.Character;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

import static com.nechinc.dnd.character.util.SkillModifierCalculator.calculateSkillModifiers;

@Service
@RequiredArgsConstructor
public class SkillService {

    private final CharacterService characterService;

    public ClassMasteryDto getMasterySkills(String skillName) {
        ClassMasteryDto classMasteryDto = new ClassMasteryDto();
        classMasteryDto.setClassSkills(SkillConst.getClassSkillMap().get(skillName.toLowerCase()));
        classMasteryDto.setCountOfSkills(SkillConst.getClassSkillCountMap().get(skillName.toLowerCase()));
        return classMasteryDto;
    }

    public Map<Skill, Integer> getCharSkills(UUID id) {
        Character character = characterService.getCharacterById(id);
        return calculateSkillModifiers(character);
    }
}
