package com.nechinc.dnd.character.service;

import com.nechinc.dnd.character.model.ClassEnum;
import com.nechinc.dnd.character.model.entity.Class;
import com.nechinc.dnd.character.repository.ClassRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ClassService {

    private final ClassRepository classRepository;

    @Named("getClassByName")
    public Class getByName(ClassEnum name) {
        return classRepository.findByName(name).orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, String.format("Class with name: %s not found", name)));
    }
}
