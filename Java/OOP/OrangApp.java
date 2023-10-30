public class OrangApp {

    public static void main(String[] args) {

        var orang1 = new Orang();

        System.out.println(orang1.nama);
        System.out.println(orang1.umur);
        System.out.println(orang1.alamat);
        orang1.perkenalan();
        orang1.sapa("dawi");
    }
}
