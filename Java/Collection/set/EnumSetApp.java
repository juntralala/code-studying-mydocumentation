package set;
/**
* EnumSet adalah Set yang elemen datanya harus Enum
* karena data Enum itu unik, sehingga sangat cocok menggunakan Set dibadingkan List
*/

import java.util.EnumSet;
import java.util.Set;

public class EnumSetApp{
    public static void main(String[] args) {
        
    //    Set<Gender> genders = EnumSet.allOf(Gender.class);
        Set<Gender> genders = EnumSet.of(Gender.FEMALE, Gender.FEMALE, Gender.MALE);
        
        for (var val : genders) {
            System.out.println(val);
        }
        
    }
    
    public static enum Gender {
        MALE,
        FEMALE,
        NOT_MENTION
    }
}