
public class DataApp {
	public static void main(String[] args) {
        
        
		Data<String> dataNama = new Data<String>("ujun");
        Data<Integer> dataUmur = new Data<>(19);
        
        System.out.println(dataNama.getData());
        System.out.println(dataUmur.getData());
        
        
	}
}