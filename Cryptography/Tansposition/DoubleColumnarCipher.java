package Tansposition;

public class DoubleColumnarCipher {

    public static String encrypt(String plainText, String key1, String key2) {
        return ColumnarCipher.encrypt(ColumnarCipher.encrypt(plainText, key1), key2);
    }

    public static String encrypt(String plainText, String key) {
        return encrypt(plainText, key, key);
    }

    public static String decrypt(String cipherText, String key1, String key2) {
        return ColumnarCipher.decrypt(ColumnarCipher.decrypt(cipherText, key2), key1);
    }

    public static String decrypt(String cipherText, String key) {
        return decrypt(cipherText, key, key);
    }


    public static void main(String[] args) {
        String teks = "UNISKABJB";
        String key = "KEY";

        String encrypted = encrypt(teks, key);
        String decrypted = decrypt(encrypted, key);

        System.out.println("encrypted = " + encrypted);
        System.out.println("decrypted = " + decrypted);
    }
}
