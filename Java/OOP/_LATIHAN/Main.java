package _LATIHAN;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> numbers = new HashMap<>();
        numbers.put(0, "Nol");
        numbers.put(1, "Satu");
        numbers.put(2, "Dua");
        numbers.put(3, "Tiga");
        numbers.put(4, "Empat");
        numbers.put(5, "Lima");
        numbers.put(6, "Enam");
        numbers.put(7, "Tujuh");
        numbers.put(8, "Delapan");
        numbers.put(9, "Sembilan");

        java.util.Scanner userInput = new java.util.Scanner(System.in);

        System.out.print("Masukkan angka : ");
        String inputan = userInput.nextLine();

        for (int i = 0; i < inputan.length() ; i++) {
            System.out.print(numbers.get(Integer.valueOf(String.valueOf(inputan.charAt(i)))) + " ");
        }

    }
}
