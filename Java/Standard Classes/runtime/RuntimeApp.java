package runtime;

public class RuntimeApp {
    public static void main(String[] args) {

        Runtime rt = Runtime.getRuntime();

        System.out.println(rt.availableProcessors());
        System.out.println(rt.freeMemory());    // ini memori jvm, bukan memuri hardware
        System.out.println(rt.totalMemory());
        System.out.println(rt.maxMemory());
    }
}
