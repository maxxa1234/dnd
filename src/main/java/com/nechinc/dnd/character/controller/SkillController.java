package com.nechinc.dnd.character.controller;

import com.nechinc.dnd.character.model.Skill;
import com.nechinc.dnd.character.model.dto.ClassMasteryDto;
import com.nechinc.dnd.character.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/character/skills")
@RequiredArgsConstructor
public class SkillController {

    private final SkillService skillService;


    @GetMapping("/mastery/{class}")
    public ClassMasteryDto getMasterySkills(@PathVariable("class") String skillName) {
        return skillService.getMasterySkills(skillName);
    }

    @GetMapping("/{id}")
    public Map<Skill, Integer> getCharSkills(@PathVariable UUID id) {
        return skillService.getCharSkills(id);
    }
}
