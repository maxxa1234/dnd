package com.nechinc.dnd.character.model.dto;

import com.nechinc.dnd.character.model.SkillEnum;

import java.util.Set;
import java.util.UUID;

public record CharacterDto(UUID id, String name, String race, String characterClass, int level, int strength,
                           int dexterity, int constitution, int intelligence,
                           int wisdom,
                           int charisma,
                           String backgroundStory,
                           Set<SkillEnum> backgroundSkills,
                           Set<SkillEnum> selectedSkills) {
}
