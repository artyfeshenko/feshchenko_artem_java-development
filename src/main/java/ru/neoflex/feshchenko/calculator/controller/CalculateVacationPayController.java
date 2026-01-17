package ru.neoflex.feshchenko.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.neoflex.feshchenko.calculator.dto.VacationPayRequest;
import ru.neoflex.feshchenko.calculator.dto.VacationPayResponse;
import ru.neoflex.feshchenko.calculator.service.CalculateVacationPayService;

import javax.validation.Valid;

@RestController
public class CalculateVacationPayController {
    private final CalculateVacationPayService calculateVacationPayService;

    public CalculateVacationPayController(CalculateVacationPayService calculateVacationPayService) {
        this.calculateVacationPayService = calculateVacationPayService;
    }

    @GetMapping("/calculacte")
    public VacationPayResponse calculateVacationPay(@Valid @RequestBody VacationPayRequest request) {
        return new VacationPayResponse(calculateVacationPayService.calculateVacationPay(request.getAvgSalary(), request.getVacationDays(), request.getStartDate(), request.getEndDate()));
    }
}
