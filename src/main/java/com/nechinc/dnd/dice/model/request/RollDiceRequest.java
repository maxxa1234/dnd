package com.nechinc.dnd.dice.model.request;

import java.util.Set;


public record RollDiceRequest(Set<RollRequest> roll) {
}
