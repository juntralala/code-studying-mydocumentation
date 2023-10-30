package string;

import java.util.StringJoiner;

public class StringJoinerApp {
    public static void main(String[] args) {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");

        joiner.add("Muhammad");
        joiner.add("Junaidi");
        joiner.add("Al");
        joiner.add("Rantaui");

        System.out.println(joiner);
        System.out.println(joiner.length());
    }
}
