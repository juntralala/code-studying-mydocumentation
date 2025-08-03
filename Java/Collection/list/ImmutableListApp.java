package list;

/**
* secara default, List di java mau itu ArrayList atau LinkedList bersifat mutable(bisa dirubah)
* di java mendukung immutable list, artinya datanya tidak bisa diubah lagi
* sekali List dibuat, datanya tidak bisa diubah lagi, alias final
* tapi ingat, hanya data list yang tidak bisa diubah, bukan references object element-nya, kalo misal kiat membuat imutable List berisikan data Person, fild data Person bisa diubah, tapi element isi imutable List tidak bisa diubah lagi
* ini cocok ketika kasus-kasus misal, tidak sembarang kode yang boleh mengubah elemen di List
*/

import data.Person;
import java.util.List;

public class ImmutableListApp{
    public static void main(String[] args) {
        Person orang = new Person("Ujun");
        orang.addHobby("main game");
        orang.addHobby("makan");
        orang.addHobby("guring");
        
        doSomthingWithHobbies(orang.getHobbies());
        
        for (var val : orang.getHobbies()) {
            System.out.println(val);
        }
    }
    
    public static void doSomthingWithHobbies(List<String> hobbies) {
    //    hobbies.add("bukan hobby"); // ERROR // karna List immutable
    }
}