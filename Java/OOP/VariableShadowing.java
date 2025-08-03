public class VariableShadowing {
    String nama; // <- bukan field disini
    String alamat;

    VariableShadowing(String nama, String alamat) { // <- parameter disini
        nama = nama;  // <- nama disini mengakses
        alamat = alamat;
    }

}