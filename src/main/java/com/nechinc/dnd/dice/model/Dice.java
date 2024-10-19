package com.nechinc.dnd.dice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Dice {

    D20(20), D12(12), D10(10), D8(8), D6(6), D4(4);

    private final int maxValue;
}
