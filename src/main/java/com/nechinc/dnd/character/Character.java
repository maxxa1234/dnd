package com.nechinc.dnd.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nechinc.dnd.character.model.Skill;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    @Column(name = "backgroundSkill")
    @JsonProperty("backgroundSkills")
    private Set<Skill> backgroundSkills;


    @ElementCollection(targetClass = Skill.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "character_skill_proficiencies", joinColumns = @JoinColumn(name = "character_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "skill")
    @JsonProperty("selectedSkills")
    private Set<Skill> skillProficiencies;

}
