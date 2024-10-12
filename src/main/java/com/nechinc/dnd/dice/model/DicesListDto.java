package com.nechinc.dnd.dice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class DicesListDto {
    private ArrayList<Dice> resultOfDices;
    private int sum;

    public DicesListDto(ArrayList<Dice> resultOfDices) {
        this.resultOfDices = resultOfDices;
    }
}
