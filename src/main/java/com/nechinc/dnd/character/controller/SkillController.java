package com.nechinc.dnd.character.controller;

import com.nechinc.dnd.character.model.ClassEnum;
import com.nechinc.dnd.character.model.dto.ClassMasteryDto;
import com.nechinc.dnd.character.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/skills")
@RequiredArgsConstructor
public class SkillController {

    private final SkillService skillService;


    @GetMapping("/{class}")
    public ClassMasteryDto getDefaultClassSkills(@PathVariable("class") ClassEnum className) {
        return skillService.getDefaultClassSkills(className);
    }
}
