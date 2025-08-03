package com.ujun;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Set;

public class ZoneId_ZoneOffsett_Test {
    @Test
    @Order(1000)
    public void createZoneId(){
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);

        ZoneId zoneId2 = ZoneId.of("Asia/Jakarta");
        System.out.println(zoneId2);

        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
//        zoneIds.forEach(System.out::println);
    }

    @Test
    public void createZoneOffset(){
        var zoneOffset1 = ZoneOffset.systemDefault();
        System.out.println(zoneOffset1);

        var zoneOffset2 = ZoneOffset.of("+07:00");
        var zoneOffset3 = ZoneOffset.ofHours(7);
        var zoneOffset4 = ZoneOffset.ofHours(-7);

        System.out.println(zoneOffset2);
        System.out.println(zoneOffset3);
        System.out.println(zoneOffset4);
    }

    @Test
    public void castingZoneOffsetToZoneId(){
        var zoneOffset = ZoneOffset.of("+07:00");
        var zoneId = zoneOffset.normalized();

        System.out.println(zoneId);
    }
}
