package ru.neoflex.feshchenko.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculateVacationPayService {
    public double calculateVacationPay(double salary, int vacationDays) {
        return salary * vacationDays / 29.3;
    }
}
