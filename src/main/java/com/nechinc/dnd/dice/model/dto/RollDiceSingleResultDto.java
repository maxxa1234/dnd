package com.nechinc.dnd.dice.model.dto;

import com.nechinc.dnd.dice.model.Dice;

import java.util.List;

public record RollDiceSingleResultDto(Dice dice, List<Integer> results, int times) {
}
