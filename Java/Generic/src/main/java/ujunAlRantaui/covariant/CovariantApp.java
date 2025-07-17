package ujunAlRantaui.covariant;

/**
* covariant artinya bisa melakukan substitusi subtype(child) dengan supertype(parent)
* caranya agar object generic kita menjadi covariant adalah dengan menggunakan kata kunci (? extends ParentClass)
* artinya saat kita membuat generic object Contoh<String>, maka bisa disubstitusi menjadi Contoh<? extends Object>
* covariant adalah read-only, jadi kita todak bisa merubah data generic nya
*/

public class CovariantApp {
    public static void main(String[] args) {
        Data<String> dataTeks = new Data<>("rezki");
        
        Data<? extends Object> DataO = dataTeks;
        
        doIt(dataTeks);
        
    }
    
    public static void doIt(Data<? extends Object> data) {
        System.out.println(data.getData());
        
        // data.setData(1); //ERROR
    }
}