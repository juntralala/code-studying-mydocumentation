package exception_Throwable_RuntimeException_Error;

public class ValidationApp {
    public static void main(String[] args) {

        LoginRequest lr = new LoginRequest(null, null);

        // Throwable Exception
        try {
            ValidationUtil.validate(lr);
            System.out.println("Data Valid");
        } catch (ValidationException | NullPointerException e) { // menangkap dua exception sekaligus
            System.out.println("Data tidak Valid");
            System.out.println("Pesan error  : " + e.getMessage() );
        } finally {
            System.out.println("Selalu di ekeekusi");
        }

        // runtime Exception
        try {
            ValidationUtil.validateRuntime(lr);
            System.out.println("Data Valid");
        } catch (BlankException | NullPointerException e) { // menangkap dua exception sekaligus
            System.out.println("Data tidak Valid");
            System.out.println("Pesan error  : " + e.getMessage() );
        } finally {
            System.out.println("Selalu di ekeekusi");
        }


//        try {
//            ValidationUtil.validate(lr);
//            System.out.println("Data Valid");
//        } catch (ValidationException e) {
//            System.out.println("Data tidak Valid");
//            System.out.println("Pesan error  : " + e.getMessage() );
//        } catch (NullPointerException  e) {
//            System.out.println("Pesan error : " + e.getMessage());
//        }

    }
}
