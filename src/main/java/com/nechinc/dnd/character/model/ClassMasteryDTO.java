package com.nechinc.dnd.character.model;

import lombok.Data;

import java.util.Set;

@Data
public class ClassMasteryDTO {
    private Set<Skill> classSkills;
    private Integer countOfSkills;
    private Set<Skill> allAvailableSkills;

    public ClassMasteryDTO() {
        this.allAvailableSkills = Set.of(Skill.values());
    }
}
