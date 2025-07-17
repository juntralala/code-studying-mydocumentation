package ujunAlRantaui.comparable;

import java.util.Arrays;

/**
* sebelumnya kita sudah tau bahwa operator perbandingan Object menggunakan method equals
* bagaimana dengan operator perbandingan lainnya? seperti kurang dari atau lebih dari
* opertor perbandingan tersebut, bisa kita lakukan jika object kita mewarisi interface generic Comparable
* ini banyak sekali digunakan, seperti untuk proses pengurutan data misalnya
* https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/Comparable.html
*/

public class ComparableApp {
    public static void main(String[] args) {

        Person[] people = {
          new Person("UJUN", "Rantau Darat"),
          new Person("Junaidi", "Handil Labuan Amas"),
          new Person("Taichou", "Tidak Diketahui")
        };

        Arrays.sort(people);

        System.out.println(Arrays.toString(people));

    }
}
