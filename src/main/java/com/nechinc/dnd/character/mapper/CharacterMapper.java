package com.nechinc.dnd.character.mapper;

import com.nechinc.dnd.character.model.dto.CharacterDto;
import com.nechinc.dnd.character.model.dto.request.CreateCharacterRequest;
import com.nechinc.dnd.character.model.entity.Character;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CharacterMapper {

    public abstract CharacterDto toDto(Character character);

    public abstract Character toEntity(CreateCharacterRequest request);
}
