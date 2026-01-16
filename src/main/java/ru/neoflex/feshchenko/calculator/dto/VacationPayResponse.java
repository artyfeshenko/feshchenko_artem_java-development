package ru.neoflex.feshchenko.calculator.dto;

public class VacationPayResponse {
    private double vacationPay;

    public VacationPayResponse(double vacationPay) {
        this.vacationPay = vacationPay;
    }

    public double getVacationPay() {
        return vacationPay;
    }
}
