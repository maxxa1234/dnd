package com.nechinc.dnd.dice.controller;

import com.nechinc.dnd.dice.model.Dice;
import com.nechinc.dnd.dice.model.DiceRequest;
import com.nechinc.dnd.dice.model.DicesListDto;
import com.nechinc.dnd.dice.service.DiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/dice")
@RequiredArgsConstructor
public class DiceController {

    private final DiceService diceService;

    @PostMapping("/valuesOfDices")
    public DicesListDto generateValueOfDice(@RequestBody DiceRequest diceRequest) {
        System.out.println("Request body: " + diceRequest);
        System.out.println("isSum: " + diceRequest.isSum());
        return diceService.calculateValueOfDice(diceRequest);
    }
}
