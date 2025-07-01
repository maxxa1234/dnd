package com.nechinc.dnd.character.model.dto.request;

import com.nechinc.dnd.character.model.ClassEnum;
import com.nechinc.dnd.character.model.SkillEnum;

import java.util.Set;

public record CreateCharacterRequest(String name, String race, ClassEnum characterClass, int level, int strength,
                                     int dexterity, int constitution, int intelligence,
                                     int wisdom,
                                     int charisma,
                                     String backgroundStory,
                                     Set<SkillEnum> backgroundSkills,
                                     Set<SkillEnum> selectedSkills) {
}
