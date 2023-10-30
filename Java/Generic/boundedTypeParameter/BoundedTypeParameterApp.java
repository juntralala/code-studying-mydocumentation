/**
* kadang kita ingin membatasi data yang boleh digunakan generic parameter type
* kita bisa menambahkan constraint di generic parameter type dengan menyebutkan tipe yang di perbolehkan
* secara otomatis, tipe yang bisa digunakan adalah tipe yang disebutkan, atau class turunannya
* secara default, constraint type generic parameter type adalah Object, makanya semua tipe data bisa digunakan
*/

public class BoundedTypeParameterApp {
    public static void main(String[] args) {
        
        DataNumber<Short> dataAngka = new DataNumber(300);
        
        System.out.println(dataAngka.getData());
        
    }

    public static class DataNumber<T extends Number> {
        private T dataNumber;

        public DataNumber(T dataNumber) {
            this.dataNumber = dataNumber;
        }

        public T getData() {
            return this.dataNumber;
        }

        public void setData(T dataNumber) {
            this.dataNumber = dataNumber;
        }
    }
}