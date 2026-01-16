package ru.neoflex.feshchenko.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.neoflex.feshchenko.calculator.dto.VacationPayResponse;
import ru.neoflex.feshchenko.calculator.service.CalculateVacationPayService;

@RestController
public class CalculateVacationPayController {
    private final CalculateVacationPayService calculateVacationPayService;

    public CalculateVacationPayController(CalculateVacationPayService calculateVacationPayService) {
        this.calculateVacationPayService = calculateVacationPayService;
    }

    @GetMapping("/calculacte")
    public VacationPayResponse calculateVacationPay(@RequestParam double avgSalary, @RequestParam int vacationDays) {
        return new VacationPayResponse(calculateVacationPayService.calculateVacationPay(avgSalary, vacationDays));
    }
}
