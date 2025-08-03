import java.sql.Array;

public class operasiArray {

    public static void main(String[] args) {

        String[] varArray = {"Ujun", "Ajid", "Danu"};

        varArray[1] = "Hendra";
        System.out.println("Panjang array : " + varArray.length);
        System.out.println("Panjang array : " + varArray.hashCode());

    }

}
