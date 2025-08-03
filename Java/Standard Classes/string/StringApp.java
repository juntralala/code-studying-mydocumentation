package string;

public class StringApp {
    public static void main(String[] args) {

    String name = "Muhammad Junaidi";
    String nameLower = name.toLowerCase();
    String nameUpper = name.toUpperCase();

    System.out.println("name : " + name);
    System.out.println("nameLower : " + nameLower);
    System.out.println("nameUpper : " + nameUpper);

    System.out.println("name.length()  : " + name.length());
    System.out.println("name.startWith : " + name.startsWith("Muhammad"));
    System.out.println("name.endWith   : " + name.endsWith("Junaidi"));
    System.out.println("name.endWith   : " + name.split(" "));
    System.out.println("\"  \".isBlank() : " + "  ".isBlank());
    System.out.println("\"  \".isEmpty() : " + "  ".isEmpty());
    System.out.println("\"\".isEmpty()   : " + "".isEmpty());
    System.out.println("name.charAt(0) : " + name.charAt(0));

    char[] chars = name.toCharArray();

    System.out.println("\"  Hello  \".trim() : " + "  Hello   ".trim());
    System.out.println("name.ubstring  : " + name.substring(5 , 14));

    }
}
