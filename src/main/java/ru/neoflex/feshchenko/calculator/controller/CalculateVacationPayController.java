package ru.neoflex.feshchenko.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculateVacationPayController {
    @GetMapping("/calculacte")
    public double calculateVacationPay() {
        return 0.0;
    }
}
