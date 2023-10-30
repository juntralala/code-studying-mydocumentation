package exception_Throwable_RuntimeException_Error;

public class DatabaseApp {
    public static void main(String[] args) {
        connectDatabase("UJUN", "1234");
        System.out.println("Akhir program");
    }

    public static void connectDatabase(String userName, String password) {
        if (userName == null || password == null) {
            throw new DatabaseError("Tidak bisa connect ke database");
        }
    }

}
