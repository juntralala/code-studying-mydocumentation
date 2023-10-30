package map;

/**
* EnumMap adalah implementasi Map dimana key nya adalah enum
* karena data enum sudah pasti unik, jadi sangat cocok dijadikan key di Map
* alhoritma pendistribusian key dioptimalkan untuk enum, sehinga lebih optimal dibandingkan hascode() method
*/

import java.util.Map;
import java.util.EnumMap;

public class EnumMapApp {
    
    public static enum Level {
        STANDARD,
        PREMIUM,
        VIP
    }
    
    public static void main(String[] args) {
        Map<Level, String> levels = new EnumMap(Level.class);
        
        levels.put(Level.PREMIUM, "Udin");
        levels.put(Level.VIP, "Ilham");
        levels.put(Level.STANDARD, "Ipul");
        
        for(var key : levels.keySet()) {
        	System.out.println(levels.get(key));
        }
    }
}