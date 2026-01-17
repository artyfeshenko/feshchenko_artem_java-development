package ru.neoflex.feshchenko.calculator.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

public class VacationPayRequest {
    @NotNull(message = "Salary is not specified")
    @Positive(message = "The salary cannot be negative or zero")
    private Double avgSalary;

    @Positive(message = "The number of vacation days cannot be negative or zero")
    private Integer vacationDays;

    private LocalDate startDate;
    private LocalDate endDate;

    public double getAvgSalary() {
        return avgSalary;
    }

    public void setAvgSalary(double avgSalary) {
        this.avgSalary = avgSalary;
    }

    public Integer getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(Integer vacationDays) {
        this.vacationDays = vacationDays;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
