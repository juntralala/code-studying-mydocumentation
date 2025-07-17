package hashCode;

import java.util.Objects;

/**
 * Kontrak hashCode method
 * 1. Sebanyak apapun object di panggil, untuk object yang sama, harus menghasilkan data integer yang sama
 * 2. jika ada 2 object yang sama jika dbandingkan menggunakan method equals, maka nilai hashCodenya juga harus sama
 * 3. Tidak wajib hashCode berbeda jika method equals menghasil false, karena memang keterbatasan integer sekitar 2 miliar
 */

public class HashCode {
    String nama;
    String alamat;
    Integer umur;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HashCode hashCode = (HashCode) o;

        if (!Objects.equals(nama, hashCode.nama)) return false;
        if (!Objects.equals(alamat, hashCode.alamat)) return false;
        return Objects.equals(umur, hashCode.umur);
    }

    @Override
    public int hashCode() {
        int result = nama != null ? nama.hashCode() : 0;
        result = 31 * result + (alamat != null ? alamat.hashCode() : 0);
        result = 31 * result + (umur != null ? umur.hashCode() : 0);
        return result;
    }
}
