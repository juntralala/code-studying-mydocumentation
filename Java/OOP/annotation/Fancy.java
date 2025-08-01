package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(value = {ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Fancy {

//    String name() default ""; // pengguna tidak harus memasukkan value
    String name() ;           // penggna harus memasukkan value

    String[] tags() default {};

}
