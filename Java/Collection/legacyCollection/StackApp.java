package legacyCollection;

/** Stack CLASS
 * Stack adalah imllementasi dari strukturdata LIFO (Last In Last Out)
 * namun fitur yang lebih komplit dan konsisten sudah disediakan Deque, jadi tidak ada alasan lagi menggunakan class Stack
 */

import java.util.Stack;

public class StackApp {
    public static void main(String[] args) {

        Stack<String> tumpukan = new Stack<>();
        tumpukan.push("Muhammad");
        tumpukan.push("Junaidi");
        tumpukan.push("ujun");

        for (var data = tumpukan.pop(); data != null ; data = tumpukan.pop()) {
            System.out.println(data);
        } // Harus Di try Catch

    }
}
