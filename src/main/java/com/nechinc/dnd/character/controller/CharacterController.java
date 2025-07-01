package com.nechinc.dnd.character.controller;

import com.nechinc.dnd.character.model.SkillEnum;
import com.nechinc.dnd.character.model.dto.CharacterDto;
import com.nechinc.dnd.character.model.dto.request.CreateCharacterRequest;
import com.nechinc.dnd.character.service.CharacterService;
import com.nechinc.dnd.character.service.CharacterSkillsModifiersCalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/characters")
@RequiredArgsConstructor
public class CharacterController {

    private final CharacterService characterService;
    private final CharacterSkillsModifiersCalculatorService characterSkillsModifiersCalculatorService;

    @GetMapping
    public List<CharacterDto> getAllCharacters() {
        return characterService.getAllCharacters();
    }

    @PostMapping
    public CharacterDto createCharacter(@RequestBody CreateCharacterRequest request) {
        return characterService.createCharacter(request);
    }

    @GetMapping("/{id}")
    public CharacterDto getCharacterById(@PathVariable UUID id) {
        return characterService.getCharacter(id);
    }

    @GetMapping("/skills/modifiers/calculate/{id}")
    public Map<SkillEnum, Integer> calculateSkillModifiers(@PathVariable UUID id) {
        return characterSkillsModifiersCalculatorService.calculateSkillModifiers(id);
    }

    @PutMapping("/{id}")
    public CharacterDto updateCharacter(@PathVariable UUID id, @RequestBody CreateCharacterRequest request) {
        return characterService.updateCharacter(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteCharacter(@PathVariable UUID id) {
        characterService.deleteCharacter(id);
    }


}
