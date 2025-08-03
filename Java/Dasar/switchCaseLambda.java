public class switchCaseLambda {
    public static void main(String[] args) {

        String nilai = "D";

        switch (nilai) {
            case "A" -> System.out.println("Anda Lulus dengan baik");
            case "B" -> System.out.println("Anda Lulus dengan nilai cukup baik");
            case "C","D" -> System.out.println("Anda Lulus rendah");
            default -> {
                System.out.println("Anda Mungkin salah jurusan");
                System.out.println("Maaf, anda belum lulus");
            }
        }

        // contoh switch <SALAH>
        String ucapan = null;
        switch (nilai) {
            case "A" -> ucapan = "Anda Lulus dengan baik";
            case "B" -> ucapan = "Anda Lulus dengan nilai cukup baik";
            case "C","D" -> ucapan = "Anda Lulus rendah";
            default ->  ucapan = "Anda Mungkin salah jurusan";
        }
        System.out.println(ucapan);


        // contoh switch <BENAR>
        ucapan = switch (nilai) {
            case "A" ->  "Anda Lulus dengan baik";
            case "B" ->  "Anda Lulus dengan nilai cukup baik";
            case "C","D" ->  "Anda Lulus rendah";
            default ->   "Anda Mungkin salah jurusan";
        };
        System.out.println(ucapan);


    }
}
