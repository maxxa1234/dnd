package com.nechinc.dnd.character.skill;

import com.nechinc.dnd.character.Character;
import com.nechinc.dnd.character.CharacterRepository;
import com.nechinc.dnd.character.service.CharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/health")
@RequiredArgsConstructor
public class HealthController {
    private final CharacterService service;
    private final CharacterRepository characterRepository;

    @PostMapping("/{id}")
    public Character calculateHealth(@PathVariable Long id) {
        Character character = characterRepository.findById(id).orElse(null);
        if(character != null) {
            character.setMaxHealth(service.calculateCharacterMaxHealth(character));
            return character;
        }
        return null;
    }
}
