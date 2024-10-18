package com.nechinc.dnd.character.controller;

import com.nechinc.dnd.character.Character;
import com.nechinc.dnd.character.CharacterRepository;
import com.nechinc.dnd.character.model.Skill;
import com.nechinc.dnd.character.service.CharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/skills")
@RequiredArgsConstructor
public class SkillController {
    private final CharacterService service;
    private final CharacterRepository characterRepository;

    @GetMapping("/{id}")
    public Map<Skill, Integer> getCharSkills(@PathVariable Long id) {
        Character character = characterRepository.findById(id).orElseThrow(RuntimeException::new);
        return service.calculateSkillModifiers(character);
    }
}
