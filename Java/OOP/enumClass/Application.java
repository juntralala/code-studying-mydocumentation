package enumClass;

public class Application {
    public static void main(String[] args) {

        var customer = new Customer();
        customer.setName("ujun");
        customer.setLevel(Level.STANDARD);

        System.out.println(customer.getName());
        System.out.println(customer.getLevel());

    }
}

class Customer {
    private String name;
    private Level level;

    public String getName() {
        return  this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Level getLevel() {
        return  this.level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
