package Tansposition;

import java.util.*;

public class RailFenceCipher {

    public static String encrypt(String plainText, int key) {
        final char[] result = new char[plainText.length()];

        Queue<Integer> plainTextChars = new LinkedList<>(plainText.chars().boxed().toList());

        Map<Integer, List<Integer>> rows = new HashMap<>(key);
        for (int i = 1; i <= key; i++) {
            rows.put(i, new LinkedList<>());
        }
        for (int i = 1; i <= (plainText.length() - 1) / ((key - 1) * 2) + 1; i++) {
            for (int j = 1; j <= key; j++) {
                Integer singleChar = plainTextChars.poll();
                if (singleChar != null) {
                    rows.get(j).add(singleChar);
                }
            }
            for (int j = key - 1; j > 1; j--) {
                Integer singleChar = plainTextChars.poll();
                if (singleChar != null) {
                    rows.get(j).add(singleChar);
                }
            }
        }
        Queue<Integer> chars = new LinkedList<>(rows.values().stream().flatMap(Collection::stream).toList());
        for (int i = 0; i < result.length; i++) {
            result[i] = (char) chars.remove().intValue();
        }
        return new String(result);
    }

    public static String decrypt(String cipherText, int key) {
        char[] result = new char[cipherText.length()];

        int[] pattern = new int[key + (key - 2)];
        for (int i = 1; i <= key; i++) {
            pattern[i - 1] = i;
        }
        for (int i = key - 1; i > 1; i--) {
            pattern[key + (key - i) - 1] = i;
        }

        int[] charPos = new int[cipherText.length()];
        for (int i = 0; i < charPos.length; i++) {
            charPos[i] = pattern[i % pattern.length];
        }

        int[] posCounts = new int[key];
        for (int charPo : charPos) {
            posCounts[charPo - 1]++;
        }

        char[][] rows = new char[key][];
        int idx = 0;
        for (int i = 0; i < rows.length; i++) {
            rows[i] = cipherText.substring(idx, posCounts[i] + idx).toCharArray();
            idx += posCounts[i];
        }

        for (int i = 0; i < charPos.length; i++) {
            result[i] = getFirstItemNotNull(rows[charPos[i] - 1]);
        }

        return new String(result);
    }

    private static char getFirstItemNotNull(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 0) {
                char result = chars[i];
                chars[i] = 0;
                return result;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        {
            String text = "UNISKA";
//        System.out.println("UKNSAI");
            String encrypted = RailFenceCipher.encrypt(text, 3);
            String decrypted = RailFenceCipher.decrypt(encrypted, 3);
            System.out.println("encrypted = " + encrypted);
            System.out.println("decrypted = " + decrypted);
        }
        {
            String text = "WowKamuGantengBingitz";
            String encrypted = RailFenceCipher.encrypt(text, 5);
            String decrypted = RailFenceCipher.decrypt(encrypted, 5);
            System.out.println("encrypted = " + encrypted);
            System.out.println("decrypted = " + decrypted);
        }
    }
}
