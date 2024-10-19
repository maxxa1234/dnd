package com.nechinc.dnd.character.controller;

import com.nechinc.dnd.character.model.dto.CharacterDto;
import com.nechinc.dnd.character.model.dto.request.CreateCharacterRequest;
import com.nechinc.dnd.character.model.entity.Character;
import com.nechinc.dnd.character.repository.CharacterRepository;
import com.nechinc.dnd.character.constant.SkillConst;
import com.nechinc.dnd.character.model.dto.ClassMasteryDto;
import com.nechinc.dnd.character.service.CharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/characters")
@RequiredArgsConstructor
public class CharacterController {

    private final CharacterService characterService;

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

    @PutMapping("/{id}")
    public CharacterDto updateCharacter(@PathVariable UUID id, @RequestBody CreateCharacterRequest request) {
        return characterService.updateCharacter(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteCharacter(@PathVariable UUID id) {
        characterService.deleteCharacter(id);
    }


}
