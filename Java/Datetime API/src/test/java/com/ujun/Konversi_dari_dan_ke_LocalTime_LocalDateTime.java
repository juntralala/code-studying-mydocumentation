package com.ujun;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Konversi_dari_dan_ke_LocalTime_LocalDateTime {

    @Test
    public void toLocalTime(){
        var localDateTime = LocalDateTime.now();
        var toLocalTime = localDateTime.toLocalTime();
    }

    @Test
    public void toLocalDateTime(){
        var localTime = LocalTime.now();

        var localDateTime = localTime.atDate(LocalDate.of(2024, 10, 30)); // hanya bisa param LocalDate untuk menambahkan date pada time nya
        System.out.println(localDateTime);
    }

}
