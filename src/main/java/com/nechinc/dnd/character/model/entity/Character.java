package com.nechinc.dnd.character.model.entity;

import com.nechinc.dnd.character.model.Skill;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String name;
    private String race;
    private String characterClass;
    private int level;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private String backgroundStory;

    @ElementCollection(targetClass = Skill.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "character_skill_background", joinColumns = @JoinColumn(name = "character_id"))
    @Enumerated(EnumType.STRING)
    private Set<Skill> backgroundSkills;
    @ElementCollection(targetClass = Skill.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "character_skill_proficiencies", joinColumns = @JoinColumn(name = "character_id"))
    @Enumerated(EnumType.STRING)
    private Set<Skill> skillProficiencies;

}
