package anonymouseClass;

public class Application {
    public static void main(String[] args) {

        var english = new HelloWorld() {

            public void helloWorld() {
                System.out.println("Hello World");
            }

            public void sayHello(String name) {
                System.out.println("Hello " + name);
            }
        };

        var indonesia = new HelloWorld() {
            String name = "Indonesia";

            public void helloWorld() {
                System.out.println("Halo Dunia");
            }

            public void sayHello(String nama) {
                System.out.println("Halo " + nama);
            }
        };

        english.helloWorld();
        indonesia.helloWorld();
        english.sayHello("UJUN");
        indonesia.sayHello("UJUN");

    }
}
