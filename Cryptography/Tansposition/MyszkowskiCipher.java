package Tansposition;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class MyszkowskiCipher {

    private static int[] toKeyNumber(String key) {
        byte[] keyChars = key.toUpperCase().getBytes();
        int[] result = new int[keyChars.length];
        for (byte keyChar : keyChars) {
            if (!Character.isAlphabetic(keyChar)) {
                throw new RuntimeException("Key Must be Alphabet");
            }
        }

        Set<Byte> setKeyChars = new TreeSet<>();
        for (byte keyChar : keyChars) {
            setKeyChars.add(keyChar);
        }

        Byte[] distinctKeyChars = setKeyChars.toArray(Byte[]::new);
        for (int i = 0; i < keyChars.length; i++) {
            result[i] = Arrays.binarySearch(distinctKeyChars, keyChars[i]) + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        String key = "BALLOON";
        int[] keyNumbers = toKeyNumber(key);
        System.out.println("keyNumbers = " + Arrays.toString(keyNumbers));
    }

}
