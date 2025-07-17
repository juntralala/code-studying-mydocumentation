/** cara membuat imutable Map
* Collections.emtyMap()
* Collectuons.singletonMap()
* Collections.unmodifiableMap()
* Map.of()
*/

import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class ImutableMapApp{
    public static void main(String[] args) {
        
        Map<String, String> empty = Collections.emptyMap();
        Map<String, String> single = Collections.singletonMap("nama", "UNKOWN");
        
        Map<String, String> mutable = new HashMap();
        mutable.put("nama", "Muhammad Junaidi");
        mutable.put("age", "19");
        mutable.put("address", "Handil Rantau");
        Map<String, String> imutable = Collections.unmodifiableMap(mutable);
        
        Map<String, String> names = Map.of(
            "nama", "Humaidi",
            "age" , "25",
            "address", "unknown"
        );
    }
}