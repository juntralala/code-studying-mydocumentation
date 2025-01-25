package map;

/**
* IdentityHashMap adalah implementasi Map sa seperti HashMap
* yang membedakan adalah cara pengecekan kesamaan datanya, tidak menggunakan method equals() melainkan menggunakan ==(references equality)
* artinya data dianggap sama, jika memang lokasi di memory tersebut sama
*/

import java.util.Map;
import java.util.IdentityHashMap;

public class IdentityHashMapApp {
    public static void main(String[] args) {
        Map<String, String> identity = new IdentityHashMap();
        
        String nama1 = "Muhammad Junaidi";
        
        String firstName = "Muhammad";
        String lastName = "Junaidi";
        String nama2 = firstName + " " + lastName;
        
        identity.put("nama1", nama1);
        identity.put("nama2", nama2);
        System.out.println(identity.size());
    }
}