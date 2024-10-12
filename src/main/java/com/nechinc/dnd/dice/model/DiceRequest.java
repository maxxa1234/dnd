package com.nechinc.dnd.dice.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Data
@Setter
public class DiceRequest {

    private ArrayList<Dice> sizeOfDices;
    private Integer countOfCubes;
    private boolean isSum;
}
