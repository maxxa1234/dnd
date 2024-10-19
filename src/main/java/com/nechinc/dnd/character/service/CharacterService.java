package com.nechinc.dnd.character.service;

import com.nechinc.dnd.character.mapper.CharacterMapper;
import com.nechinc.dnd.character.model.dto.CharacterDto;
import com.nechinc.dnd.character.model.dto.request.CreateCharacterRequest;
import com.nechinc.dnd.character.model.entity.Character;
import com.nechinc.dnd.character.repository.CharacterRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CharacterService {

    private final CharacterRepository characterRepository;
    private final CharacterMapper characterMapper;
    private final ClassService classService;

    public List<CharacterDto> getAllCharacters() {
        return characterRepository.findAll().stream().map(characterMapper::toDto).toList();
    }

    public CharacterDto getCharacter(UUID id) {
        Character character = getCharacterById(id);
        return characterMapper.toDto(character);
    }

    public CharacterDto createCharacter(CreateCharacterRequest request) {
        Character character = characterMapper.toEntity(request);
        characterRepository.save(character);
        return characterMapper.toDto(character);
    }

    public CharacterDto updateCharacter(UUID id, CreateCharacterRequest request) {
        Character character = getCharacterById(id);
        character.setName(request.name());
        character.setRace(request.race());
        character.setCharacterClass(classService.getByName(request.characterClass()));
        character.setLevel(request.level());
        character.setStrength(request.strength());
        character.setDexterity(request.dexterity());
        character.setConstitution(request.constitution());
        character.setIntelligence(request.intelligence());
        character.setWisdom(request.wisdom());
        character.setCharisma(request.charisma());
        characterRepository.save(character);
        return characterMapper.toDto(character);
    }

    public void deleteCharacter(UUID id) {
        characterRepository.deleteById(id);
    }

    public Character getCharacterById(UUID id) {
        return characterRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Character with id %s not found", id)));
    }

}
