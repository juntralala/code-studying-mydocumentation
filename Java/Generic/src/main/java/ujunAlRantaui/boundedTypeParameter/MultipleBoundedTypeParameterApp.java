package ujunAlRantaui.boundedTypeParameter;

/**
* kadang kita ingin membatasi data dengan beberapa tipe digeneric parameter type
* kita bisa menambahkan beberapa bounded type parameter dengan karakter & setelah bounded ttpe parameter pertama
* jika ingin menambahkan lagi cukup tambahkan lagi &  diikuti bounded type nya lagi
*/

public class MultipleBoundedTypeParameterApp{
    public static void main(String[] args) {
      //  Data<Manager> dataManager = new Data<>(new Manager());  // ERROR tidak implements CanSayHello
        Data<VicePresiden> dataVicePresident = new Data<>( new VicePresiden());
        
    }
    
    public interface CanSayHello {
    	void sayHello(String name);
    }

    public static abstract class Employee{
    
    }

    public static class Manager extends Employee{
    
    }

    public static class VicePresiden extends Employee implements CanSayHello {
        public void sayHello(String name) {
            System.out.println("hello " + name);
        }
    }
    
    public static class Data<T extends Employee & CanSayHello > {
        private T data;
        
        public Data(T data) {
            this.data = data;
        }
        
        public T getData() {
            return data;
        }
        
        public void setData(T data){
            this.data = data;
        }
    }

}

