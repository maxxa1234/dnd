package com.nechinc.dnd.character.repository;

import com.nechinc.dnd.character.model.SkillEnum;
import com.nechinc.dnd.character.model.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SkillRepository extends JpaRepository<Skill, UUID> {

    Optional<Skill> findByName(SkillEnum name);
}
