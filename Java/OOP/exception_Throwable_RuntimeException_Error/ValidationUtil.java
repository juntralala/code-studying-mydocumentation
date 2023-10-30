package exception_Throwable_RuntimeException_Error;

public class ValidationUtil{

    // Throwable Exception
    public static void validate(LoginRequest loginRequest) throws ValidationException{ // harus pakai throws
        if (loginRequest.name() == null) {
            throw new NullPointerException("Name is null"); // NullPointerException adalah RuntimeException jadi tidak perlu ditambahkan kedalam throws
        }else if(loginRequest.name().isBlank()) {
            throw new NullPointerException("name is blank");
        }else if (loginRequest.password() == null) {
            throw new ValidationException("Password is null");
        }else if(loginRequest.password().isBlank()) {
            throw new ValidationException("password is blank");
        }
    }

    // runTimeException
    public static void validateRuntime(LoginRequest loginRequest) { // tidak harus pakai throws
        if (loginRequest.name() == null) {
            throw new NullPointerException("Name is null");
        }else if(loginRequest.name().isBlank()) {
            throw new NullPointerException("name is blank");
        }else if (loginRequest.password() == null) {
            throw new BlankException("Password is null");
        }else if(loginRequest.password().isBlank()) {
            throw new BlankException("password is blank");
        }
    }


}
