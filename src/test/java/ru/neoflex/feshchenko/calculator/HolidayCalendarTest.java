package ru.neoflex.feshchenko.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.neoflex.feshchenko.calculator.calendar.HolidayCalendar;

import java.time.LocalDate;

public class HolidayCalendarTest {
    private HolidayCalendar holidayCalendar;
    @BeforeEach
    public void setUp() {
        holidayCalendar =  new HolidayCalendar();
    }
    @Test
    void testIsHolidayTrue() {
        LocalDate date = LocalDate.of(2026, 1, 1);
        boolean result = holidayCalendar.isHoliday(date);
        Assertions.assertTrue(result);
    }
    @Test
    void testIsHolidayFalse() {
        LocalDate date = LocalDate.of(2026, 1, 16);
        boolean result = holidayCalendar.isHoliday(date);
        Assertions.assertFalse(result);
    }
}
