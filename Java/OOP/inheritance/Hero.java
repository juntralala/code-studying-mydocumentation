package inheritance;

class Hero {

    String name;
    String role;
    String spesial;

    Hero(String name, String role, String spesial) {

        this.name = name;
        this.role = role;
        this.spesial = spesial;

    }

    void attack(String name) {

        System.out.printf("%s attacking %s\n",this.name, name);

    }

}
