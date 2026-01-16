package ru.neoflex.feshchenko.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.neoflex.feshchenko.calculator.calendar.HolidayCalendar;
import ru.neoflex.feshchenko.calculator.service.CalculateVacationPayService;

import java.time.LocalDate;

public class CalculateVacationPayServiceTest {
    private CalculateVacationPayService calculateVacationPayService;
    private HolidayCalendar holidayCalendar;
    @BeforeEach
    void setUp() {
        holidayCalendar = Mockito.mock(HolidayCalendar.class);
        calculateVacationPayService = new CalculateVacationPayService(holidayCalendar);
    }
    @Test
    void testCalculateVacationPayByVacationDays() {
        double salary = 15000;
        int countDays = 10;
        double expected = Math.round(salary * countDays / 29.3 * 100) / 100.0;
        double actual = calculateVacationPayService.calculateVacationPay(salary, countDays, null, null);
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void testCalculateVacationPayByDateRange() {
        double salary = 15000;
        LocalDate startDate = LocalDate.of(2026, 1, 8);
        LocalDate endDate = LocalDate.of(2026, 1, 11);
        Mockito.when(holidayCalendar.isHoliday(LocalDate.of(2026,1,8))).thenReturn(true);
        Mockito.when(holidayCalendar.isHoliday(LocalDate.of(2026,1,9))).thenReturn(false);
        Mockito.when(holidayCalendar.isHoliday(LocalDate.of(2026,1,10))).thenReturn(false);
        Mockito.when(holidayCalendar.isHoliday(LocalDate.of(2026,1,11))).thenReturn(false);
        double expected = Math.round(salary * 3 / 29.3 * 100) / 100.0;
        double actual = calculateVacationPayService.calculateVacationPay(salary, null, startDate, endDate);
        Assertions.assertEquals(expected,actual);
    }
}
