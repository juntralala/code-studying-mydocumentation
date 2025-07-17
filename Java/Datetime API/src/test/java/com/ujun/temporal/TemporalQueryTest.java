package com.ujun.temporal;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;
import java.util.LinkedHashMap;
import java.util.Map;

/** TemporalQuery
 * TemporalQuery merupakan lambda interface yang bisa kita gunakan untuk mengambil informasi dari data TemporalAccessor
 * TemporalQuery adalah generic type, jadi kita bisa mengembalikan tipe data apapun pada hasil query yang kita lakukan
 * di TemporalAccessor
 */

public class TemporalQueryTest {
    @Test
    public void temporalQuery() {
        LocalDateTime localDateTime = LocalDateTime.now();

        Map<String, Integer> dateData = localDateTime.query(new TemporalQuery<Map<String, Integer>>() {
            @Override
            public Map<String, Integer> queryFrom(TemporalAccessor temporal) {
                Map<String, Integer> dateData = new LinkedHashMap<>();
                dateData.put("year", temporal.get(ChronoField.YEAR));
                dateData.put("day", temporal.get(ChronoField.MONTH_OF_YEAR));
                dateData.put("month", temporal.get(ChronoField.DAY_OF_MONTH));
                return dateData;
            }
        });

        dateData.forEach((key, data)-> System.out.println(key + " : " + data));
    }
}
