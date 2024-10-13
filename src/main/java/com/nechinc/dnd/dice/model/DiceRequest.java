package com.nechinc.dnd.dice.model;

import lombok.Data;

import java.util.List;

@Data
public class DiceRequest {

    private List<Dice> sizeOfDices;
    private Integer countOfCubes;
}
