package com.nechinc.dnd.character.repository;

import com.nechinc.dnd.character.model.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CharacterRepository extends JpaRepository<Character, UUID> {
}
