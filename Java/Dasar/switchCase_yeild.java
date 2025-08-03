public class switchCase_yeild {
    public static void main(String[] args) {

        String nilai = "A";

        String ucapan = switch (nilai) {
            case "A" : yield "Kamu lulus dengan nilai yang bagus";
            case "B" : yield "Kamu lulus dengan nilai yang cukup";
            case "C","D" : yield "KAmu lulus dengan nilai ynag rendah";
            default : yield "Mungkin kamu salah jurusan";
        };
        System.out.println(ucapan);

    }
}
