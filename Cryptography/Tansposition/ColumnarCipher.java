package Tansposition;

import java.util.Arrays;

public class ColumnarCipher {

    private static int[] toKeyNumbers(String key) {
        char[] keyChars = key.toUpperCase().toCharArray();
        for (char singleChar : keyChars) {
            if (!Character.isAlphabetic(singleChar)) {
                throw new RuntimeException("Key Must Be Alphabet Character");
            }
        }

        char[][] mapped = new char[][]{new char[keyChars.length], Arrays.copyOf(keyChars, keyChars.length)};
        Arrays.sort(mapped[1]);
        for (int i = 0; i < keyChars.length; i++) {
            mapped[0][i] = (char) (i + 1);
        }

        int[] keyNumbers = new int[keyChars.length];
        for (int i = 0; i < keyChars.length; i++) {
            for (int j = 0; j < mapped[1].length; j++) {
                if (keyChars[i] == mapped[1][j]) {
                    keyNumbers[i] = mapped[0][j];
                    mapped[0][j] = 0;
                    mapped[1][j] = 0;
                    break;
                }
            }
        }
        return keyNumbers;
    }

    public static String encrypt(String plainText, String key) {
        int[] keyNumbers = toKeyNumbers(key);
        char[] plainTextChars = plainText.toCharArray();

        int rowsAmount = plainText.length() / keyNumbers.length + (plainText.length() % keyNumbers.length == 0 ? 0 : 1);
        char[][] columns = new char[keyNumbers.length][rowsAmount];
        for (int i = 0; i < columns.length * rowsAmount; i++) {
            columns[i % keyNumbers.length][i / keyNumbers.length] = i < plainTextChars.length ? plainText.charAt(i) : 'X';
        }

        char[] result = new char[columns.length * rowsAmount];
        for (int i = 0; i < columns.length; i++) {
            System.arraycopy(columns[keyNumbers[i] - 1], 0, result, i * rowsAmount, columns[i].length);
        }

        return new String(result);
    }

    public static String decrypt(String cipherText, String key) {
        char[] result = new char[cipherText.length()];
        int[] keyNumbers = toKeyNumbers(key);
        char[] cipherTextChars = cipherText.toCharArray();

        char[][] columns = new char[keyNumbers.length][cipherTextChars.length / keyNumbers.length];
        for (int i = 0; i < columns.length; i++) {
            System.arraycopy(cipherTextChars, i * columns[0].length, columns[i], 0, columns[0].length);
        }

        for (int i = 0; i < cipherTextChars.length; i++) {
            result[i] = columns[keyNumbers[i % columns.length] - 1][i / columns.length];
        }

        return new String(result);
    }

    public static void main(String[] args) {
        String teks = "UNISKABJBA";
        String key = "KEY";

        String encrypted = encrypt(teks, key);
        String decrypted = decrypt(encrypted, key);

        System.out.println("encrypted = " + encrypted);
        System.out.println("decrypted = " + decrypted);
    }
}
