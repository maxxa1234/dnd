package com.nechinc.dnd.dice.service;

import com.nechinc.dnd.dice.model.Dice;
import com.nechinc.dnd.dice.model.dto.RollDiceResultDto;
import com.nechinc.dnd.dice.model.dto.RollDiceSingleResultDto;
import com.nechinc.dnd.dice.model.request.RollDiceRequest;
import com.nechinc.dnd.dice.model.request.RollRequest;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DiceService {

    private final Random rand = new Random();

    public RollDiceResultDto rollDice(RollDiceRequest rollDiceRequest) {
        Set<RollDiceSingleResultDto> rolls = new HashSet<>();
        for (RollRequest rollRequest : rollDiceRequest.roll()) {
            List<Integer> rollResults = getRollResults(rollRequest);
            rolls.add(new RollDiceSingleResultDto(rollRequest.dice(), rollResults, rollRequest.times()));
        }
        return new RollDiceResultDto(rolls);
    }

    private List<Integer> getRollResults(RollRequest rollRequest) {
        List<Integer> rollResults = new ArrayList<>();
        for (int i = 0; i < rollRequest.times(); i++) {
            rollResults.add(getRollResult(rollRequest.dice()));
        }
        return rollResults;
    }

    private int getRollResult(Dice dice) {
        return rand.nextInt(1, dice.getMaxValue() + 1);
    }
}