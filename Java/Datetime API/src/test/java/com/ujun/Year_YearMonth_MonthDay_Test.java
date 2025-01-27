package com.ujun;

import org.junit.jupiter.api.Test;

import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;

/**
 * Ketiga kelas ini sama saja seperti Kelas LocalDate, LocalDateTime dan LocalTime
 */
public class Year_YearMonth_MonthDay_Test {
    @Test
    public void testCreate(){
        Year year = Year.now();
        YearMonth yearMonth = YearMonth.now();
        MonthDay monthDay = MonthDay.now();

        Year yearOf = Year.of(2025);
        YearMonth yearMonthOf = YearMonth.of(2025, 5);
        MonthDay monthDayOf = MonthDay.of(5, 20);

        Year yearParsed = Year.parse("2025");
        YearMonth yearMonthParsed = YearMonth.parse("2025-05");
        MonthDay monthDayParsed = MonthDay.parse("--05-20");
    }

    @Test
    public void with(){

    }

    @Test
    public void plus(){

    }

    @Test
    public void minus(){

    }

    @Test
    public void get(){

    }
}
