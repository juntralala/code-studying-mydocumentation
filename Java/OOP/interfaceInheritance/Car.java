package interfaceInheritance;

/**
 * ketentuan Interface :
 * secara default semua field, method, dan contrsctor itu public, jadi kita perlu lagi menuliskan public
 *
 * semua method tidak boleh memiliki block
 *
 * extends bisa lebih dari 1, tidak seperti abstract class
 */

public interface Car extends hasBrand, Maintinance {

    void drive();

    int getTire();

}
