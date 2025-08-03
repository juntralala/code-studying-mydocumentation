package getter_setter;

public class Application {
    public static void main(String[] args) {

        Category honda = new Category();
        honda.setId("AB01");
        honda.setId(null);

        System.out.println(honda.getId());

    }
}
