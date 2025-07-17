package variableHiding;

public class ParentApp {

    public static void main(String[] args) {

        Child child = new Child();
        child.name = "UJUN";
        System.out.println(child.name);
        child.doIt();

        Parent parent = (Parent) child;
        System.out.println(parent.name);
        parent.doIt();
    }

}
