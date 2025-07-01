package com.nechinc.dnd.character.repository;

import com.nechinc.dnd.character.model.ClassEnum;
import com.nechinc.dnd.character.model.entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CharacterClassRepository extends JpaRepository<Class, UUID> {
    Optional<Class> findByName(ClassEnum name);
}
