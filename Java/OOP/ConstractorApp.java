public class ConstractorApp {

    public static void main(String[] args) {

        Constractor orang = new Constractor("UJUN", 19, "Handil Rantau");

        System.out.println(orang.nama);
        System.out.println(orang.umur);
        System.out.println(orang.alamat);

        orang.nama = "Kozuki Oden";

    }

}
