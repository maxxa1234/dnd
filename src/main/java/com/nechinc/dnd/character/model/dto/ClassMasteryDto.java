package com.nechinc.dnd.character.model.dto;

import com.nechinc.dnd.character.model.SkillEnum;
import lombok.Data;

import java.util.Set;

@Data
public class ClassMasteryDto {
    private Set<SkillEnum> classSkills;
    private Integer countOfSkills;
    private Set<SkillEnum> allAvailableSkills;

    public ClassMasteryDto() {
        this.allAvailableSkills = Set.of(SkillEnum.values());
    }
}
