package exception_Throwable_RuntimeException_Error;

record LoginRequest(String name, String password) {

    // compact constractor
    public LoginRequest {
        System.out.println("Membuat object LoginRequest");
    }

    public LoginRequest(String name) {
        this(name, "");
    }

    public LoginRequest() {
        this("","");
    }

}
