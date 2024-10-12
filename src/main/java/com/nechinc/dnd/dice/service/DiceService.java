package com.nechinc.dnd.dice.service;

import com.nechinc.dnd.dice.model.DiceResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class DiceService {
    private final Random rand = new Random();

    public DiceResult calculateValueOfDice(List<String> sizeOfDices, int countOfCubes, boolean isSum) {
        List<Integer> resultsOfDices = new ArrayList<>();
        for (int i = 0; i < countOfCubes; i++) {
            resultsOfDices.add(rand.nextInt(1, Integer.parseInt(sizeOfDices.get(0).substring(1)) + 1));
        }

        if (isSum) {
            return new DiceResult(resultsOfDices, resultsOfDices.stream().mapToInt(Integer::intValue).sum());
        }
        return new DiceResult(resultsOfDices);

    }
}