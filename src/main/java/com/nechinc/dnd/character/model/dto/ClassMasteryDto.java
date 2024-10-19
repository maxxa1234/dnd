package com.nechinc.dnd.character.model.dto;

import com.nechinc.dnd.character.model.Skill;
import lombok.Data;

import java.util.Set;

@Data
public class ClassMasteryDto {
    private Set<Skill> classSkills;
    private Integer countOfSkills;
    private Set<Skill> allAvailableSkills;

    public ClassMasteryDto() {
        this.allAvailableSkills = Set.of(Skill.values());
    }
}
