public class ConstractorChainingApp {

    public static void main(String[] args) {
        var ipul = new ConstractorChaining("Saipul Bahri", "Batu Licin");
        var iben = new ConstractorChaining("Ibnu Tho'i Muttasyim");
        var orang = new ConstractorChaining();

        System.out.println("nama ipul   : " + ipul.nama);
        System.out.println("alamat ipul : " + ipul.alamat);
        System.out.println("nama iben   : " + iben.nama);
        System.out.println("alamat iben : " + iben.alamat);
        System.out.println("nama orang  : " + orang.nama);
        System.out.println("alamat orang : " + orang.alamat);
    }

}
