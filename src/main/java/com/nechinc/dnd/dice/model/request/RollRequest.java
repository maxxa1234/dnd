package com.nechinc.dnd.dice.model.request;

import com.nechinc.dnd.dice.model.Dice;

public record RollRequest(Dice dice, int times) {
}
