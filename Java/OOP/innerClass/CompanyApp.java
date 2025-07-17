package innerClass;

public class CompanyApp {
    public static void main(String[] args) {

        Company perusahaan = new Company("PLN");

        Company.Emplyee akbar = perusahaan.new Emplyee("M Rafly Aulia Akbar");

        System.out.println(akbar.getName());
        System.out.println(akbar.getCompany());

    }
}
