package com.nechinc.dnd.dice.controller;

import com.nechinc.dnd.dice.service.DiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dice")
@RequiredArgsConstructor
public class DiceController {

    private final DiceService diceService;

    @GetMapping
    public List<Integer> generateValueOfDice(List<String> sizeOfDices, int countOfCubes, boolean isSum) {
        return diceService.calculateValueOfDice(sizeOfDices, countOfCubes, isSum);
    }
}
