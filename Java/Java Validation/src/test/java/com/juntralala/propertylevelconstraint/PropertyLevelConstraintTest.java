package com.juntralala.propertylevelconstraint;


import com.juntralala.MyTest;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.junit.jupiter.api.Test;

/**
 * Aku dapat ini dari Dokumentasi bukan materi pak Eko, sepertinya ini fitur baru sebelum materi pak eko dibuat,
   detail nya liat sendiri dari dokumentasi Hibernate Validation
 * Field Level Constraint itu simplenya, alih" meletakkan constraint pada field, kita letakkan pada method
   accessor seperti getter (bukan setter)

 Edit: property level sudah lama sejak hibernate versi 4 tahun 2009, tapi sepertinya memang tidak dijelaskan pak eko
 */

public class PropertyLevelConstraintTest extends MyTest {

    @Test
    public void propertyLevelConstraint() {
        var orang = new Orang("", "12");

        var violations = validator.validate(orang);
        violations.forEach(System.out::println);
    }

}

@Setter
@AllArgsConstructor
class Orang {

    private String name;
    private String age;

    @NotBlank
    @Size(min = 4, max = 100)
    public String getName() {
        return name;
    }

    @NotBlank
    @Digits(integer = 10000000, fraction = 0)
    public String getAge() {
        return age;
    }
}
