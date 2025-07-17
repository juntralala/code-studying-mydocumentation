package ujunAlRantaui.genericClass;

/** Multiple Paramter TYpe
 * Parameter type di Generic class boleh dari satu
 * Namun harus menggunakan nama type yang berbeda
 * Ini sangat berguna saat kita ingin membuat generic parameterType yang banyak
 */

public class MultipleParameterType {

    public static void main(String[] args) {

        Pair<String, Integer> pair = new Pair<String, Integer>("UJUN", 20);

        System.out.println(pair.getFisrt());
        System.out.println(pair.getSecond());

    }

    public static class Pair<T, U> {

        private T first;
        private U second;

        public Pair(T first, U second){
            this.first = first;
            this.second = second;
        }

        public T getFisrt(){
            return this.first;
        }

        public void setFisrt(T first){
            this.first = first;
        }

        public U getSecond(){
            return this.second;
        }

        public void setSecond(U second){
            this.second = second;
        }

    }

}
