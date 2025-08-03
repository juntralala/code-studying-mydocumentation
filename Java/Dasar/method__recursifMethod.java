public class method__recursifMethod {
    public static void main(String[] args) {

        /*
        * recursif method adalah kemamapuan method untuk memanggil dirinya sendiri
        */

        fungsiRekursif(5, 2, 6);

    }// mainEnd

    static int fungsiRekursif(int first , int selisih, int n){
        System.out.println(first);
        if (n == 1 || n == 0){
            return first;
        }
        return fungsiRekursif(first + selisih, selisih,n-1);
    }

}
