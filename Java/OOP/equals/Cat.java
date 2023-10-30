package equals;

import java.util.Objects;

public class Cat {
    String name;
    int age;

    public Cat(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cat cat = (Cat) o;

        if (age != cat.age) return false;
        return Objects.equals(name, cat.name);
    }
    //    public boolean equals(Object o) {
//        if (o == this) return true;
//
//        if (!(o instanceof  Cat)) return false;
//
//        Cat kucing = (Cat) o;
//
//        if (this.name != null) {
//            return this.name.equals(kucing.name);
//        } else {
//            return kucing.name == null;
//        }
//    }

}
