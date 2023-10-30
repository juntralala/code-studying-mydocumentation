package methodReferences;

import app.StringUtil;

import java.util.function.Predicate;

/**
 * kadang saat kita membuat lambda, isi lamda hanyak mengakses method lain atau mengakses method yang ada di parameter
   method lambdanya
 * kita bisa mempersingkat pembuatan lambda tersebut dengan method references
 */

public class MethodReferences {
    public static void main(String[] args) {
        // Contoh 1 STATIC CLASS
//        Predicate<String> lowerCase = value -> StringUtil.isLowerCase(value);
        Predicate<String> lowerCase = StringUtil::isLowerCase;

        System.out.println(lowerCase.test("junaidi"));
        System.out.println(lowerCase.test("JUNAIDI"));
    }

    // NONSTATIC
    // contoh 2 memanggil method didalam object itu sendiri
    public void run() {
//        Predicate<String> lowerCase = value -> MethodReferences.this.isLowerCase(value);
        Predicate<String> lowerCase = this::isLowerCase;

        System.out.println(lowerCase.test("junaidi"));
        System.out.println(lowerCase.test("JUNAIDI"));
    }

    public boolean isLowerCase(String value) {
        for (char c : value.toCharArray()) {
            if (!Character.isLowerCase(c)) {
                return false;
            }
        }
        return true;
    }

    // contoh 3 memanggil method object lain
    public void run2() {
        MethodReferences app = new MethodReferences();

        Predicate<String> lowerCase = app::isLowerCase;

        System.out.println(lowerCase.test("junaidi"));
        System.out.println(lowerCase.test("JUNAIDI"));
    }
}
