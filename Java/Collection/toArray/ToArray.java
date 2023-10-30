package toArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Collection interface
 * interface Collection memiliki method toArray() untuk melakukan konversi collection ke Array
 * ini sangat cocok jika ingin mengubah Collection ke Array, misal saja karena mau memanggil method yang memang
   parameternya tipenya Array, bukan Collection
 *
 * toArray() : Object[]
 * toArray(t[]) : T[]
 */

public class ToArray {
    public static void main(String[] args) {

        List<String> names = List.of("UJUN", "ARIF", "DAYAT", "ALIA", "HATIM", "AMI");
        Object[] objectArray = names.toArray();
        String[] stringArray = names.toArray(new String[]{});

        System.out.println(Arrays.toString(objectArray));
        System.out.println(Arrays.toString(stringArray));
    }
}
