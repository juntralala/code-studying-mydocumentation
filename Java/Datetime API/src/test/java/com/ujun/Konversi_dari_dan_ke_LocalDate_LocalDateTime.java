package com.ujun;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Konversi_dari_dan_ke_LocalDate_LocalDateTime {

    @Test
    public void toLocalDate(){
        var localDateTime = LocalDateTime.now();
        var toLocalDate = localDateTime.toLocalDate();
    }

    @Test
    public void toLocalDateTime(){
        var localDate = LocalDate.now();

        var localDateTime = localDate.atTime(20, 30); // karna tidak ada waktunya maka harus ditambakan
        System.out.println(localDateTime);
    }

}
