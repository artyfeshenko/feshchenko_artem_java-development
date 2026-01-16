package ru.neoflex.feshchenko.calculator.service;

import org.springframework.stereotype.Service;
import ru.neoflex.feshchenko.calculator.calendar.HolidayCalendar;

import java.time.LocalDate;

@Service
public class CalculateVacationPayService {
    private final HolidayCalendar holidayCalendar;

    public CalculateVacationPayService(HolidayCalendar holidayCalendar) {
        this.holidayCalendar = holidayCalendar;
    }

    public double calculateVacationPay(double salary, Integer vacationDays, LocalDate startDate, LocalDate endDate) {
        int countDays;
        if (vacationDays != null) {
            countDays = vacationDays;
        } else {
            countDays = countVacationDays(startDate, endDate);
        }
        return round(salary * countDays / 29.3);
    }

    private double round(double vacationPay) {
        return Math.round(vacationPay * 100) / 100.0;
    }

    private int countVacationDays(LocalDate startDate, LocalDate endDate) {
        LocalDate currentDate = startDate;
        int countVacationDays = 0;
        while (!currentDate.isAfter(endDate)) {
            if (!holidayCalendar.isHoliday(currentDate)) {
                countVacationDays++;
            }
            currentDate = currentDate.plusDays(1);
        }
        return countVacationDays;
    }
}
