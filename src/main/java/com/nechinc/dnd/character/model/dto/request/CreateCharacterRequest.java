package com.nechinc.dnd.character.model.dto.request;

import com.nechinc.dnd.character.model.Skill;

import java.util.Set;

public record CreateCharacterRequest(String name, String race, String characterClass, int level, int strength,
                                     int dexterity, int constitution, int intelligence,
                                     int wisdom,
                                     int charisma,
                                     String backgroundStory,
                                     Set<Skill> backgroundSkills,
                                     Set<Skill> selectedSkills) {
}
