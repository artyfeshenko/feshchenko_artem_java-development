package ru.neoflex.feshchenko.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculateVacationPayService {
    public double calculateVacationPay(double salary, int vacationDays) {
        return round(salary * vacationDays / 29.3);
    }
    public double round(double vacationPay) {
        return Math.round(vacationPay * 100) / 100.0;
    }
}
