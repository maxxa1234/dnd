package com.nechinc.dnd.dice.service;

import com.nechinc.dnd.dice.model.Dice;
import com.nechinc.dnd.dice.model.DiceRequest;
import com.nechinc.dnd.dice.model.DicesListDto;
import com.sun.jdi.IntegerType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class DiceService {
    private final Random rand = new Random();

    public DicesListDto calculateValueOfDice(DiceRequest diceRequest) {
        ArrayList<Dice> resultsOfDices = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < diceRequest.getCountOfCubes(); i++) {
            resultsOfDices.add(new Dice(diceRequest.getSizeOfDices().get(i).getDice(), rand.nextInt(1,
                    Integer.parseInt(diceRequest.getSizeOfDices().get(i).getDice().substring(1))+1)));
            sum += resultsOfDices.get(i).getResult();
        }

        if (diceRequest.isSum()) {
            return new DicesListDto(resultsOfDices, sum);
        }
        return new DicesListDto(resultsOfDices);

    }
}