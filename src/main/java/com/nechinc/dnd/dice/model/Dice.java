package com.nechinc.dnd.dice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
public class Dice {

    private String dice;
    private int result;

    public Dice(String dice) {
        this.dice = dice;
    }
}
