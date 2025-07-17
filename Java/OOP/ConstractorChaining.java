public class ConstractorChaining {

    String nama;
    String alamat;

    ConstractorChaining(String name, String almat) {
        nama = name;
        alamat = almat;
    };

    ConstractorChaining(String name) {
        this(name, "Tidak dikatahui");
    };

    ConstractorChaining() {
        this("Anonymous");
    };

}
