package enumMembers;

/**
 * sama seperti class biasanya, di class enum pun kita bisa menambahkan members(fiels, method dan constractor)
 *
 * Khusus constractor, kita tidak bisa membuat public constractor, karna memangt tujuan unum bukan untuk di instansiasi
 * secara bebas
 */

public class EnumMembers {
    public static void main(String[] args) {

        var ujun = new Customer("Muhamad Junaidi", Level.STANDARD);

        System.out.println(ujun.getName());
        System.out.println(ujun.getLevel());
        System.out.println(ujun.getLevel().getDescription());

    }
}
