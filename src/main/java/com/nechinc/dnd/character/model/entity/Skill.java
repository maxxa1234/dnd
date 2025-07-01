package com.nechinc.dnd.character.model.entity;

import com.nechinc.dnd.character.model.AbilityScore;
import com.nechinc.dnd.character.model.SkillEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private SkillEnum name;

    @Enumerated(EnumType.STRING)
    private AbilityScore abilityScore;
    @ManyToMany
    private Set<Class> classes = new HashSet<>();
}
