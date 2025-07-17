package toString;

public class Ilmu {

    public String nama;
    public String pencetus;

    public Ilmu(String nama, String pencetus) {
        this.nama = nama;
        this.pencetus = pencetus;
    }

   public String toString() {
        return String.format("nama : %s, pencetus : %s",this.nama, this.pencetus);
    }

}
