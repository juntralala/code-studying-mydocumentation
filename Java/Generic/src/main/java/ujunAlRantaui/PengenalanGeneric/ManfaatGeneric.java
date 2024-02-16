package ujunAlRantaui.PengenalanGeneric;

/** Manfaat Generic
 * Pengecekan ketika Proses kompilasi
 * Tidak perlu manual menggunakan pengecekkan tipe data dan konversi tipe data
 * Memudahkan programmer membuat kode program yang generic sehingga bisa digunakan oleh berbagai tipe data
 */

public class ManfaatGeneric {

    public static void main(String[] args){

        // contoh kode tidak Generic
        Data1 dataString = new Data1();
        dataString.setData("UJUN");
        String value = (String) dataString.getData();

        // contoh kode Generic
        Data2<String> dataString2 = new Data2<String>();
        dataString2.setData("UJUN");
        String value2 = dataString2.getData();


    }

    // contoh tidak generic
    static class Data1{
        private Object data;

        public Object getData(){
            return this.data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }

    // contoh generic
    static class Data2<T> {
        private T data;

        public T getData() {
            return this.data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }

}
