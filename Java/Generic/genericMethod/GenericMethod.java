/**
 * Generic paramter type tidak hanya bisa digunakan pada Class atau Interface
 * kita juga bisa menggunakan genric parameter type di method
 * Genric parameter type yang kita deklarasikan di method, hanya bisa diakses di method tersebut,
   tidak bisa digunakan di luar method
 * ini cocok jika kita ingin membuat generic method, tanpa harus merubah deklarasi class
 */

public class GenericMethod {
    public static void main(String[] args) {
        
        Integer[] numbers = {1,2,3,4};
        String[] names = {"ujun", "ajid"};
        
        int panjang1 = HitungPanjang.hitung(numbers);
        int panjang2 = HitungPanjang.<String>hitung(names);
        
        System.out.println( panjang1 );
        System.out.println( panjang2 );

    }
    
    public static <T> int hitung(T[] larik) {
        return larik.length;
    }
    
}