package com.nechinc.dnd.character.service;

import com.nechinc.dnd.character.model.ClassEnum;
import com.nechinc.dnd.character.model.entity.Class;
import com.nechinc.dnd.character.repository.CharacterClassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class CharacterClassService {
    private final CharacterClassRepository characterClassRepository;

    public Class findClassByName(ClassEnum className) {
        return characterClassRepository.findByName(className)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Class with name: %s is not found", className)));
    }
}
