package com.nechinc.dnd.character.model;

import lombok.Data;

import java.util.Set;

@Data
public class ClassMasteryDTO {
    private Set<Skill> classSkills;
    private Integer countOfSkills;
}
