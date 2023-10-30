/**
* contravariant artinya kita bisa melakukakan substitusi supertype(parent) dengan subtype(child)
* caranya agar generic object kita menjadi contravariant adalah dengan menggunakan kata kunci <? super ParentClass>
* artinya saat kita membuat object Contoh<Object>, maka kita bisa mensubstitusinya dengan Contoh<? super String>
* contravariant biasa write dan read, namun perlu berhati hati ketika melakukan read, terutama jika parent nya memiliki banyak child
*/

public class ContravariantApp {
    public static void main(String[] args) {
        
        Data<Object> data = new Data<>("ujun");
        Data<? super String> dataNama = data;
        
        process(data);
        
        System.out.println(data.getData());
        
    }
    
    public static void process(Data<? super String> data) {
        
        // String dataTeks = data.getData();  // ERROR // karan getdata mereturn Object bukan string
        
        data.setData("Junaidi");
    }
}