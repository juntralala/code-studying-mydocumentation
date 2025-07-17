package bigNumber;

// jika number yang kita gunakan melebihi kapasitas long maka kita bisa menggunakan BigInteger class
// tapi, karna BigInteger bukan tipedata sebenarnya, jadi tidak bisa menggunakan operator aritmatik,
// karna itu kita harus menggunakan method jika ingin melakukan perhitungan
// add()        ->  +
// substract()  ->  -
// multiply()   ->  *
// divide()     ->  /
// mod()       ->  %

import java.math.BigInteger;

public class BigIntegerApp {
    public static void main(String[] args) {

        Long varLong = 1_000_000_000_000_000_000L; // 19 dijit
        BigInteger a = new BigInteger("1000000000000000000000"); // lebih dari 19 dijit
        BigInteger b = new BigInteger("1000000500000000000000");

        var result = a.add(b);

        System.out.println(result);
        System.out.println(a.subtract(b));
        System.out.println(a.max(b));

    }
}
