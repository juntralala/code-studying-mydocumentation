package inheritance;

public class MarksmanApp {
    public static void main(String[] args) {

    Hero layla = new Hero("Layla", "Marksman", "Damage");
    System.out.println(layla.name);
    System.out.println(layla.role);
    layla.attack("Miya");

    Marksman miya = new Marksman("Miya", "Damage");

    System.out.println(miya.name);
    System.out.println(miya.role);
    miya.attack("Layla");

    }
}
