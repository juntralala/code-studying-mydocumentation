public class konversiReferencesDataType {

    public static void main(String[] args) {

        int varInt = 20;

        Integer varInteger = varInt;

        varInt = varInteger;

        long varLong = varInteger.longValue();
        short varShort = varInteger.shortValue();

    }

}


