package com.nechinc.dnd.dice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DiceRequest {

    private List<Dice> sizeOfDices;
    private Integer countOfCubes;
}
