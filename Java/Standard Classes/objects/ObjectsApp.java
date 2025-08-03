package objects;

import java.util.Objects;

/**
 * perhatikan jangan sampai tertukar, ini class Objects, bukan Object
 *
 * Objects adalah class utility yang berisikan banyak static method yang bisa kita gunakan untk operasi object
 * atau melakukan pengecekan sebelum operasinya di lakukan
 */

public class ObjectsApp {
    public static void main(String[] args) {

        var data1 = new Data("Ujun");
        execute(data1);
        execute(null);

    }

    public static void execute(Data data) {
        System.out.println(Objects.toString(data)); // karna pakai Objects meskipun data yang diirimkan null tidak error
        System.out.println(Objects.hashCode(data));
    }

}

class Data {
    String name;
    Data(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Data{" +
                "name='" + name + '\'' +
                '}';
    }
}
