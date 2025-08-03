package Subtitution;

public class CaesarCipher {

    public static String encrypt(String plainText, int shift) {
        char[] result = new char[plainText.length()];
        byte shiftTarget = (byte) (shift % 26);
        int i = 0;
        for (char singleChar : plainText.toCharArray()) {
            if (Character.isAlphabetic(singleChar)) {
                char boundary = (Character.isUpperCase(singleChar)) ? 'A' : 'a';
                byte singleCharMapped = (byte) (singleChar - boundary);
                byte shifted = (byte) ((singleCharMapped + shiftTarget) % 26);
                char shiftedChar = (char) (boundary + shifted);
                result[i++] = (shiftedChar < boundary) ? (char) (shiftedChar + 26) : shiftedChar;
            } else {
                result[i++] = singleChar;
            }
        }
//        new Cipher();
        return new String(result);
    }

    public static String decrypt(String cipherText, int shift) {
        return CaesarCipher.encrypt(cipherText, -shift);
    }

    public static void main(String[] args) {
        String text = "Wow Kamu Ganteng Bingitz";

        String encryptedText = CaesarCipher.encrypt(text, 3);
        String decryptedText = CaesarCipher.decrypt(encryptedText, 3);

        System.out.println("encryptedText = " + encryptedText);
        System.out.println("decryptedText = " + decryptedText);
    }
}
