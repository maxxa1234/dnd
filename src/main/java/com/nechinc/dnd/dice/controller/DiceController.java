package com.nechinc.dnd.dice.controller;

import com.nechinc.dnd.dice.model.dto.RollDiceResultDto;
import com.nechinc.dnd.dice.model.request.RollDiceRequest;
import com.nechinc.dnd.dice.service.DiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dice")
@RequiredArgsConstructor
public class DiceController {

    private final DiceService diceService;

    @PostMapping("/roll")
    public RollDiceResultDto rollDice(@RequestBody RollDiceRequest rollDiceRequest) {
        System.out.println("Request body: " + rollDiceRequest);
        return diceService.rollDice(rollDiceRequest);
    }
}
