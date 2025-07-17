package enumConvertion;

public class EnumConvertion {
    public static void main(String[] args) {

        var ujun = new Customer("Muhamad Junaidi", Level.STANDARD);

        System.out.println(ujun.getName());
        System.out.println(ujun.getLevel());

        // konversi enum ke String
        String enumName = Level.VIP.name();
        System.out.println( enumName);

        // String ke enum
        Level level = Level.valueOf("PREMIUM");
        System.out.println( level);

        // enum ke array
        Level[] levels = Level.values();
        System.out.println(levels instanceof Level[]);
        for (var val : levels) {
            System.out.println(val);
        }

    }
}
