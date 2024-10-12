package com.nechinc.dnd.dice.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class DiceService {
    private final Random rand = new Random();

    public int calculateValueOfDice(List<String> sizeOfDices, int countOfCubes){
        List<Integer> resultsOfDices = new ArrayList<>();
        for (int i = 0; i < countOfCubes; i++) {
            resultsOfDices.add(rand.nextInt(1, Integer.parseInt(sizeOfDices.get(0).substring(1))+1));
        }

        if(resultsOfDices.size() == 1){
            return resultsOfDices.get(0);
        }
        return resultsOfDices.stream().mapToInt(Integer::intValue).sum();

    }
}
