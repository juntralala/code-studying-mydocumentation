public class konversiBilangan {

    public static void main(String[] args) {
        /*
        * konversi bilanagn pada java ada 2 :
        * 1. Widening casting(Otomatis) : byte -> short -> int -> long -> float -> double
        * 2. Narrowing casting(manual)  : double -> float -> long -> int -> char -> short -> byte
        */

        /*Widening Casting*/
        byte varByte = 10;
        short varShort = varByte;
        int varInt = varShort;
        long varLong = varInt;
        float varFloat = varLong;
        double varDouble = varLong;

        /*Narrowing Casting*/
        varDouble = 10;
        varFloat = (float) varDouble;
        varLong = (long) varFloat;
        varInt = (int) varLong;
        char varChar = (char) varInt;
        varShort = (short) varChar;
        varByte = (byte) varShort;



    }

}