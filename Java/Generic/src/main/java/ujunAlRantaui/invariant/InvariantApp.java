package ujunAlRantaui.invariant;

/**
 * secara default, saat kita membuat generic parameter type, parameter tersebut bersfat invariant
 * invariant artinya todak boleh di substitusi dengan subtype(child) atau subtype(parent)
 * artinya ketika kita membuat object Contoh<String>, maka tidak  sama dengan Contoh<Object>, begitu juga sebaliknya,
   saat membuat Contoh<Object> maka tidak sama dengan Contoh<String>
*/

public class InvariantApp {
    public static void main(String[] args) {
        Data<String> dataTeks = new Data<>("Ujun");
    //    Data<Object> DataObject = dataTeks;  // ERROR
        
        Data<Object> data = new Data<>(123);
    //    Data<Integer> dataAngka = data; // ERROR
        
    //    doIt(dataTeks)  // ERROR
    }
    
    static void doIt(Data<Object> data) {
        // do nothing
    }
}