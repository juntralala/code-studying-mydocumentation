package number;

/** Semua Number Class memiliki method ini :
 * UNTUK Mengkonveri Ke number lain:
 * 1. byteValue()
 * 2. shortValue()
 * 3. intValue()
 * 4. longValue()
 * 5. floatValue()
 * 6. doubleValue()
 *
 * UNTUK Mengkonversi String ke Number,
 * number class memiliki static method untuk konversi
 * parseXxx(String)    -> string ke tipe data primitif
 * valueOfXxx(String)  -> string ke tipe data non primitif
 * method ini akan throw NumberFormatException, jika tenyata gagal melakukan konversi String ke-number,
 */

public class Number {
    public static void main(String[] args) {

        Integer val = 10;
        Long longVal = val.longValue();
        Byte byteVal = val.byteValue();
        Double doubleVal = val.doubleValue();

        Integer contohIntVal = Integer.valueOf("123");  // mereturn Integer object
        Float contohFloatVal = Float.valueOf("10.5");

        System.out.println(contohIntVal);
        System.out.println(contohFloatVal);
    }
}
