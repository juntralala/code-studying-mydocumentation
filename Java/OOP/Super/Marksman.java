package Super;

public class Marksman extends Hero {

    Marksman(String name) {
        super(name, "Marksman");
    }

    String getParentType() {
        return super.getType();
    }

}
