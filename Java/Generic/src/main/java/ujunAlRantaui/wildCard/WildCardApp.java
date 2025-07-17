package ujunAlRantaui.wildCard;

/**
* kadang ada kasus dimana kita tidqk peduli dengan tipe generic parameter type pada object
* misalkan kita ingin mem-print data T, tidak peduli tipe data apapun
* jika kita mengalami kasus seperti ini, kita bisa menggunakan wildcard
* wildcard bisa dibuat dengan mengganti generic parameter type dengan karaktee ?
*/

public class WildCardApp{
    public static void main(String[] args) {
        
        printData(new Data<>("Junaidi")); 
        printData(new Data<>(123456));
        printData(new Data<>(3.14));
        
    }
    
    public static void printData(Data<?> data) {
        System.out.println(data.getData());
    }
}