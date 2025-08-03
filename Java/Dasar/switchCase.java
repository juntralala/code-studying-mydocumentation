public class switchCase {
    public static void main(String[] args) {

         String nilai = "D";

         switch (nilai) {
             case "A" :
                 System.out.println("Anda Lulus dengan baik");
                 break;
             case "B" :
                 System.out.println("Anda Lulus dengan nilai cukup baik");
                 break;
             case "C","D" :
                 System.out.println("Anda Lulus rendah");
                 break;
             default :
                 System.out.println("Anda Mungkin salah jurusan");
                 break;
         }

    }
}
