public class ConstractorOverloadingApp {

    public static void main(String[] args) {

        var orang = new ConstractorOverloading("Ujun");
        var orang2 = new ConstractorOverloading("Ujun", "Handil Rantau");

        System.out.println(orang.nama);

    }

}
