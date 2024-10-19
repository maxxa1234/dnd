package com.nechinc.dnd.character.mapper;

import com.nechinc.dnd.character.model.dto.CharacterDto;
import com.nechinc.dnd.character.model.dto.request.CreateCharacterRequest;
import com.nechinc.dnd.character.model.entity.Character;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class CharacterMapper {

    @Mapping(source = "skillProficiencies", target = "selectedSkills")
    public abstract CharacterDto toDto(Character character);

    @Mapping(source = "selectedSkills", target = "skillProficiencies")
    public abstract Character toEntity(CreateCharacterRequest request);
}
