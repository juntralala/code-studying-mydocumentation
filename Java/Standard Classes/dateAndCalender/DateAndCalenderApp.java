package dateAndCalender;

import java.util.Calendar;
import java.util.Date;

/**
 * Tiap bahasa pemrograman biasanya memliki representas tanggal, dijava juga sama, ada class Date & Calander yang bisa
 * digunakan sebagai representaasi tanggal
 *
 * SEBENARNYA di Java 8 sdah ada cara manipulasi tanggal yang baru menggunakan Java Date Time API, namun ini akan kita
 * bahsa di coursse terpisah
 *
 * sekarang kita akan fokus mengunakan class Date dam Calender yang lama
 *
 * -> HUBUNGAN Date & Calender :
 * class Date adalah class representasi tanggal sampai milisexond
 *
 * Namun di class date sudah banyak method-method yang di deprecated, sehngga ntuk memanipulasi date tanggal, kita harus
 * melakukan kombinasi antara class Date & Calender
 *
 * sederhanyanya Date untuk representasi tangggal dan Calender untuk mannipulasi tanggal
 */

public class DateAndCalenderApp {
    public static void main(String[] args) {

        Date sekarang = new Date();
        Date tanggal = new Date(1400560200000L); // tanggal dalam mili second

        System.out.println(sekarang);
        System.out.println(tanggal);

        Calendar kalender = Calendar.getInstance(); // pertamkasi di stansiasi tanggal saat ini
        kalender.set(Calendar.YEAR, 2004);
        kalender.set(Calendar.MONTH, Calendar.MAY);
        kalender.set(Calendar.DAY_OF_MONTH, 20);

        Date result = kalender.getTime();
        System.out.println(result);

    }
}
