package dev.juntralala;

import org.apache.catalina.User;
import org.springframework.lang.NonNull;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class PersonValidator implements Validator {

    @Override
    public boolean supports(@NonNull Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(@NonNull Object target, @NonNull Errors errors) {
        Person person = (Person) target;
        if (person.getName() == null) {
            errors.rejectValue("name", "person.name.empty", "Nama tidak boleh kosong");
        }
        if (person.getAge() <= 16) {
            errors.rejectValue("age", "person.age.old", "Usia harus lebih dari 16 tahun");
        }
    }
}
