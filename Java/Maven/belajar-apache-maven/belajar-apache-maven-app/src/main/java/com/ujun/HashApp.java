package com.ujun;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashApp {

    public static String hash(String input) throws NoSuchAlgorithmException {
        // Memperoleh instance MessageDigest untuk SHA-256
        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        // Mengubah string input menjadi bytes dan menghitung hash
        byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));

        // Mengkonversi byte array menjadi representasi hex
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString();
    }

    public static void main(String[] args) {
        try {
            String input = "Contoh pesan";
            String hashValue = hash(input);
            System.out.println("Input: " + input);
            System.out.println("Hash SHA-256: " + hashValue);
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Algoritma SHA-256 tidak tersedia: " + e.getMessage());
        }
    }
}