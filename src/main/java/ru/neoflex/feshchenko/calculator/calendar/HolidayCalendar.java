package ru.neoflex.feshchenko.calculator.calendar;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.MonthDay;
import java.util.Set;

@Component
public class HolidayCalendar {
    private static final Set<MonthDay> VACATION_DAYS = Set.of(
            MonthDay.of(1,1),
            MonthDay.of(1,2),
            MonthDay.of(1,3),
            MonthDay.of(1,4),
            MonthDay.of(1,5),
            MonthDay.of(1,6),
            MonthDay.of(1,7),
            MonthDay.of(1,8),
            MonthDay.of(2,23),
            MonthDay.of(3,8),
            MonthDay.of(5,1),
            MonthDay.of(5,9),
            MonthDay.of(6,12),
            MonthDay.of(11,4)
    );
    public boolean isHoliday(LocalDate date) {
        return VACATION_DAYS.contains(MonthDay.from(date));
    }
}
