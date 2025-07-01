package com.nechinc.dnd.dice.model.dto;

import java.util.Set;

public record RollDiceResultDto(Set<RollDiceSingleResultDto> results) {
}
