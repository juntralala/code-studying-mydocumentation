package _LATIHAN;

public class PersegiApp {
    public static void main(String[] args) {

        Persegi lapangan = new Persegi(60, 127);

        System.out.println(lapangan.luas());
        System.out.println(lapangan.kelliling());
        System.out.println(lapangan);

    }
}

record Persegi (Integer panjang,Integer tinggi ) {

    Persegi(Integer panjang, Integer tinggi) {
        this.panjang = panjang;
        this.tinggi = tinggi;
    }

    public Integer luas() {
        return panjang * tinggi;
    }

    public Integer kelliling() {
        return panjang + tinggi * 2;
    }

    @Override
    public String toString() {
        return String.format("panjang\t: %1$05d \ntinggi\t: %2$05d", panjang, tinggi);
    }

}
