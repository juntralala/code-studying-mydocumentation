package dev.juntralala;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;

public class BeanUtilsTest {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class Name {
        private String firstName;
        private String lastName;
    }

    @Test
    public void test() {
        System.out.println(BeanUtils.isSimpleProperty(String.class));
        System.out.println(BeanUtils.isSimpleProperty(Name.class));
    }
}
