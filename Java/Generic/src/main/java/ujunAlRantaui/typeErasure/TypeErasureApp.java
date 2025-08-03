package ujunAlRantaui.typeErasure; /**
* Type Erasure adalah proses pengecekan generic pada saat  compile time, dan menghiraukan pengecekan pada saat runtime
* Type Erasure menjadikan type generic yang kita buat akan hilang ketika code telah dicompile menjadi binary file
* Compiler akan mengubah generic parameter type menjadi Object di java
*/

/** PROBLEM
* karena geric informasi hilang ketika kode telah menjadi binary file
* oleh karena itu, konveris tipe data generic akan sangat berbahaya jika dilakukan secara tidak bijak
*/

public class TypeErasureApp {
    public static void main(String[] args) {
        Data<String> dataString = new Data<>("ujun");
        
//        Data<Integer> dataInteger = (Data<Integer>) dataString; // ERROR // data string tidak bisa dikonversi menjadi Data<Integer>
//        Integer angka = dataInteger.data;
    }
    
    static class Data<T> {
        public T data;
        
        Data(T data) {
            this.data = data;
        }
    }
}