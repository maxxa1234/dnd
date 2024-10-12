package com.nechinc.dnd.dice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class DiceResult {
    private List<Integer> resultOfDices;
    private int sumOfDices;

    public DiceResult(List<Integer> resultOfDices) {
        this.resultOfDices = resultOfDices;
    }
}
