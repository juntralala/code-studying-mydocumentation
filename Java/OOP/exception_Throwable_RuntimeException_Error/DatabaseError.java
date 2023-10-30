package exception_Throwable_RuntimeException_Error;

public class DatabaseError extends Error{
    DatabaseError(String message) {
        super(message);
    }
}
