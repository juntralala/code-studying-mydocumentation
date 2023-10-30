package polimorphism;

public class PolimorphismApp {
    public static void main(String[] args) {

        Employee employee = new Employee("UJUN");
        employee = new Manager("UJUN");
        employee = new VicePresident("UJUN");

        Manager manager = new Manager("UDIN");
        VicePresident vicePresident = new VicePresident("IPUL");

        sayHello(employee);
        sayHello(manager);
        sayHello(vicePresident);

    }

    public static void sayHello(Employee employee) {
        System.out.println("Hai " + employee.name);
    }

}
