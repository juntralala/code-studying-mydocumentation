package variableHiding;

public class Parent {
    String name;

    public void doIt() {
        System.out.println("Do It Parent");
    }

}

class Child extends Parent {

    String name;

    public void doIt() {
        System.out.println("Do It Child");
    }

}
