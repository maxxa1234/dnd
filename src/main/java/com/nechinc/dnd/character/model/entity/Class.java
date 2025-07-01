package com.nechinc.dnd.character.model.entity;

import com.nechinc.dnd.character.model.ClassEnum;
import com.nechinc.dnd.dice.model.Dice;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Enumerated(EnumType.STRING)
    private ClassEnum name;
    @Enumerated(EnumType.STRING)
    private Dice healthDice;
    private Integer defaultClassSkillsCount;
    @ManyToMany
    @JoinTable(
            name = "class_default_skills",
            joinColumns = {@JoinColumn(name = "class_id")},
            inverseJoinColumns = {@JoinColumn(name = "skill_id")}
    )
    private Set<Skill> defaultClassSkills;
}
