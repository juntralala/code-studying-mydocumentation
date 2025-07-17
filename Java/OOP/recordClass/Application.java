package recordClass;

public class Application {
    public static void main(String[] args) {

        var loginRequest = new LoginRequest("Ujun", "rahasia");

        System.out.println(loginRequest.name());
        System.out.println(loginRequest.password());
        System.out.println(loginRequest);

        System.out.println(new LoginRequest());
        System.out.println(new LoginRequest("UJUN"));
        System.out.println(new LoginRequest("UDIN", "Palingkau"));

    }
}
