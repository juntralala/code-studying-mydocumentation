package com.juntralala.messageinterpolation;

import com.juntralala.MyTest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class MessageInterpolationTest extends MyTest {

    @Test
    public void testMessageInterpolation() {
        Order order = new Order("", 500L);

        Set<ConstraintViolation<Order>> violations = validator.validate(order);

        violations.forEach(violation ->
                System.out.println(violation.getPropertyPath().toString() + ": " + violation.getMessage()));
        Assertions.assertEquals(3, violations.size());
    }

}

@Data
@AllArgsConstructor
class Order {

    @NotBlank(message = "{order.id.notblank}")
    @Size(min = 1, max = 10, message = "{order.id.size}")
    private String id;

    @Range(min = 10000, max = 100_000_000_000L, message = "{order.amount.range}")
    private Long amount;

}

// langsung di hardcode juga bisa
//    @Size(min = 1, max = 10, message = "order id must between {min} and {max} characters")
//    @Range(min = 10000, max = 100_000_000_000L, message = "order amount must between {min} and {max}")
