package com.ujun;


import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;

/**
 * Yang menarik di Java Date & Time adalah, memiliki implementasi data hari
 * Data hari ini beruba Enum DayOfWeek, namun dia adalah turunan dari Temporal, sehingga operasi yang bisa dilakukan
 * di Temporal bisa kita lakukan disini, seperti menambah atau mengurangi
 */

public class DayOfWeekTest {
    @Test
    public void week() {
        DayOfWeek dayOfWeek1 = DayOfWeek.MONDAY;
        DayOfWeek dayOfWeek2 = dayOfWeek1.plus(2);
        DayOfWeek dayOfWeek3 = dayOfWeek1.minus(1);

        System.out.println("dayOfWeek1 = " + dayOfWeek1);
        System.out.println("dayOfWeek2 = " + dayOfWeek2);
        System.out.println("dayOfWeek3 = " + dayOfWeek3);
    }
}
