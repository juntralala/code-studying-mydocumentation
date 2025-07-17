# Validate Container Data
* Untuk melakukan validasi data jenis container, Bean Validation membutuhkan yang namanya Value Extractor
* Value Extractor ini menjadikan Bean Validation bisa melakukan ekstraksi data dari container
* Secara default, Bean Validation mendukung semua data container yang tersedia di Java, seperti Optional, Collection, List, Iterable, Set dan Map
* Yang kita butuhkan, hanya dengan menambahkan Constraint pada generic type container tersebut

Contoh salah:
```java
import java.util.List;

public class Person {

    @Valid
    @NotBlank
    private List<String> hobbies;
    
}
```