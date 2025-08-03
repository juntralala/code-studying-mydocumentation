public class methodVariableArgument {

    public static void main(String[] args) {

        bilangSelamat("Muhammad Junaidi", 80,96,65,88);

    }

    public static void bilangSelamat(String nama, int... args) {
        int totalNilai = 0;

        for (int val : args) {
            totalNilai += val;
        }

        int finalNilai = totalNilai / args.length;
        String ucapan = nama + ((finalNilai >= 70) ? ", Selamat kamu lulus" :", coba lagi tahun depan");
        System.out.println(ucapan);

    }

}
