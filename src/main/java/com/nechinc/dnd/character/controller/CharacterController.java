package com.nechinc.dnd.character.controller;

import com.nechinc.dnd.character.Character;
import com.nechinc.dnd.character.CharacterRepository;
import com.nechinc.dnd.character.constant.SkillConst;
import com.nechinc.dnd.character.model.ClassMasteryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
@RequiredArgsConstructor
public class CharacterController {

    private final CharacterRepository characterRepository;

    @GetMapping
    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }

    @PostMapping
    public Character createCharacter(@RequestBody Character character) {
        return characterRepository.save(character);
    }

    @GetMapping("/{id}")
    public Character getCharacterById(@PathVariable Long id) {
        return characterRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Character updateCharacter(@PathVariable Long id, @RequestBody Character characterDetails) {
        Character character = characterRepository.findById(id).orElse(null);
        if (character != null) {
            character.setName(characterDetails.getName());
            character.setRace(characterDetails.getRace());
            character.setCharacterClass(characterDetails.getCharacterClass());
            character.setLevel(characterDetails.getLevel());
            character.setStrength(characterDetails.getStrength());
            character.setDexterity(characterDetails.getDexterity());
            character.setConstitution(characterDetails.getConstitution());
            character.setIntelligence(characterDetails.getIntelligence());
            character.setWisdom(characterDetails.getWisdom());
            character.setCharisma(characterDetails.getCharisma());
            return characterRepository.save(character);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteCharacter(@PathVariable Long id) {
        characterRepository.deleteById(id);
    }

    @GetMapping("/skill/{class}")
    public ClassMasteryDTO getMasterySkills(@PathVariable("class") String skillName) {
        ClassMasteryDTO classMasteryDTO = new ClassMasteryDTO();
        classMasteryDTO.setClassSkills(SkillConst.getClassSkillMap().get(skillName.toLowerCase()));
        classMasteryDTO.setCountOfSkills(SkillConst.getClassSkillCountMap().get(skillName.toLowerCase()));
        return classMasteryDTO;
    }
}
