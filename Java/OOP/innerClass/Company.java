package innerClass;

public class Company {

    private String name;

    Company(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public class Emplyee {

        private String name;

        Emplyee(String name) {
            this.name = name;

        }

        public String getCompany() {
            return Company.this.name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

}
