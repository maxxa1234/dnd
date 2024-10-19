package com.nechinc.dnd.character.service;

import com.nechinc.dnd.character.model.ClassEnum;
import com.nechinc.dnd.character.model.SkillEnum;
import com.nechinc.dnd.character.model.dto.ClassMasteryDto;
import com.nechinc.dnd.character.model.entity.Class;
import com.nechinc.dnd.character.model.entity.Skill;
import com.nechinc.dnd.character.repository.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SkillService {

    private final ClassService classService;
    private final SkillRepository skillRepository;

    public ClassMasteryDto getDefaultClassSkills(ClassEnum classEnum) {
        Class cl = classService.getByName(classEnum);
        ClassMasteryDto classMasteryDto = new ClassMasteryDto();
        classMasteryDto.setClassSkills(cl.getDefaultClassSkills().stream().map(Skill::getName).collect(Collectors.toSet()));
        classMasteryDto.setCountOfSkills(cl.getDefaultClassSkillsCount());
        return classMasteryDto;
    }

    @Named("getSkillsByNames")
    public Set<Skill> getSkillsByNames(Set<SkillEnum> skillNames) {
        return skillNames.stream().map(this::getSkillByName).collect(Collectors.toSet());
    }


    private Skill getSkillByName(SkillEnum name) {
        return skillRepository.findByName(name).orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, String.format("Skill with name: %s not found", name)));
    }
}
