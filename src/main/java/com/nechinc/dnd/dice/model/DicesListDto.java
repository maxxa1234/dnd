package com.nechinc.dnd.dice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DicesListDto {
    private List<Dice> resultOfDices;
    private int sum;

    public DicesListDto(List<Dice> resultOfDices) {
        this.resultOfDices = resultOfDices;

        for (Dice d : resultOfDices) {
            sum += d.getResult();
        }
    }
}
