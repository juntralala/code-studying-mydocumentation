package dev.juntralala;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;

public class DataBinderTest {

    @Test
    public void createInstance() {
        Person person = new Person();
        DataBinder binder = new DataBinder(person);
    }

    @Test
    public void bindingConstructor() {
        // class Binding Contructor perlu ValueResolver dan ValueResolver tidak punya class implementasi yang public
        // jadi tidak ada contoh
    }

    @Test
    public void bindingProperty() {
        Person person = new Person();
        DataBinder binder = new DataBinder(person);
        binder.setConversionService(new DefaultConversionService());

        Map<String, String> personProperties = new HashMap<>();
        personProperties.put("name", "Ujun");
        personProperties.put("age", "12");
        binder.bind(new MutablePropertyValues(personProperties));

        assertThat(person, hasProperty("name", is("Ujun")));
        assertThat(person, hasProperty("age", is(12)));
    }

    @Test
    public void bindingPropertyWithValidation() {
        Assertions.assertThrows(BindException.class, () -> {
            Person person = new Person();
            DataBinder binder = new DataBinder(person);
            binder.setConversionService(new DefaultConversionService());

            // nambah satu baris ini
            binder.addValidators(new PersonValidator());

            Map<String, String> personProperties = new HashMap<>();
            personProperties.put("name", "Ujun");
            personProperties.put("age", "12");
            binder.bind(new MutablePropertyValues(personProperties));

            // dan ini
            binder.validate();
            BindingResult bindingResult = binder.getBindingResult();

            assertThat(person, hasProperty("name", is("Ujun")));
            assertThat(person, hasProperty("age", is(12)));

            // dan ini
            if (bindingResult.hasErrors()) {
                throw new BindException(bindingResult);
            }
        });
    }
}
