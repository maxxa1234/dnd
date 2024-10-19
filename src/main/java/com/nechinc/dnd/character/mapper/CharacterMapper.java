package com.nechinc.dnd.character.mapper;

import com.nechinc.dnd.character.model.SkillEnum;
import com.nechinc.dnd.character.model.dto.CharacterDto;
import com.nechinc.dnd.character.model.dto.request.CreateCharacterRequest;
import com.nechinc.dnd.character.model.entity.Character;
import com.nechinc.dnd.character.model.entity.Skill;
import com.nechinc.dnd.character.service.ClassService;
import com.nechinc.dnd.character.service.SkillService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {ClassService.class, SkillService.class})
public abstract class CharacterMapper {

    @Mapping(source = "characterClass.name", target = "characterClass")
    @Mapping(source = "selectedBackgroundSkills", target = "backgroundSkills", qualifiedByName = "mapSkills")
    @Mapping(source = "selectedClassSkills", target = "selectedSkills", qualifiedByName = "mapSkills")
    public abstract CharacterDto toDto(Character character);

    @Mapping(target = "characterClass", qualifiedByName = "getClassByName")
    @Mapping(target = "selectedBackgroundSkills", source = "backgroundSkills", qualifiedByName = "getSkillsByNames")
    @Mapping(target = "selectedClassSkills", source = "selectedSkills", qualifiedByName = "getSkillsByNames")
    public abstract Character toEntity(CreateCharacterRequest request);

    @Named("mapSkills")
    protected Set<SkillEnum> mapSkills(Set<Skill> skills) {
        return skills.stream().map(Skill::getName).collect(Collectors.toSet());
    }
}
