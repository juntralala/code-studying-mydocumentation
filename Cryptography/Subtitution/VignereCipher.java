package Subtitution;

public class VignereCipher {

    public static String encrypt(String plainText, String key) {
        final int[] keyNumbers = key.chars()
                .map(item -> item - (Character.isUpperCase(item) ? 'A' : 'a'))
                .toArray();
        return VignereCipher.shift(plainText, keyNumbers);
    }

    public static String decrypt(String cipherText, String key) {
        final int[] keyNumbers = key.chars()
                .map(item -> -(item - (Character.isUpperCase(item) ? 'A' : 'a')))
                .toArray();
        return VignereCipher.shift(cipherText, keyNumbers);
    }

    private static String shift(String text, int[] keyNumbers) {
        char[] result = new char[text.length()];
        final int keyAmount = keyNumbers.length;
        int i = 0;
        for (char singleChar : text.toCharArray()) {
            if (Character.isAlphabetic(singleChar)) {
                int boundary = Character.isUpperCase(singleChar) ? 'A' : 'a';
                int mappedChar = singleChar - 'A';
                int shiftedChar = ((mappedChar + keyNumbers[i % keyAmount]) % 26) + boundary;
                result[i] = (char) (shiftedChar < boundary ? shiftedChar + 26 : shiftedChar);
            } else {
                result[i] = singleChar;
            }
            i++;
        }
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        String text = "APA TUH KIRA-KIRA";
        String key = "KUNCI";

        String encrypted = VignereCipher.encrypt(text, key);
        String decrypted = VignereCipher.decrypt(encrypted, key);

        System.out.println("encrypted = " + encrypted);
        System.out.println("decrypted = " + decrypted);
    }
}
