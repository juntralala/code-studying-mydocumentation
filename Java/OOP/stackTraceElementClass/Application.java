package stackTraceElementClass;

public class Application {
    public static void main(String[] args) {

        try {
            String[] names = {"UJUN", "AJID", "ARIF"};
            System.out.println(names[10]);
        } catch (Throwable t) {
            t.printStackTrace();
        }

    }
}
