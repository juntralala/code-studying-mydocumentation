package com.juntralala.messageinternationalization;

import com.juntralala.MyTest;
import jakarta.validation.MessageInterpolator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.internal.engine.MessageInterpolatorContext;
import org.hibernate.validator.messageinterpolation.ExpressionLanguageFeatureLevel;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageInternationalizationTest extends MyTest {

    @Test
    public void testMessageIndonesia() {
        Locale.setDefault(Locale.of("id", "ID")); // <- dengan Locale.setDefault

        var order = new Order("", 0L);
        var violations = validator.validate(order);

        violations.forEach(violation -> {
            System.out.printf("%s: %s -> %s%n",
                    violation.getPropertyPath(), violation.getMessage(), violation.getMessageTemplate());
        });
    }

    @Test
    public void testMessageAmerica() {
        Locale.setDefault(Locale.of("en", "US"));

        var order = new Order("", 0L);
        var violations = validator.validate(order);

        violations.forEach(violation -> {
            System.out.printf("%s: %s -> %s%n",
                    violation.getPropertyPath(), violation.getMessage(), violation.getMessageTemplate());
        });
    }

    @Test
    public void testInternationalizationWithMessageInterpolator(){ // indonesia
        Order order = new Order("", 0L);

        var violations = validator.validate(order);
        MessageInterpolator messageInterpolator = validatorFactory.getMessageInterpolator();
        for (var violation : violations) {
            System.out.println(violation.getMessageTemplate());

            MessageInterpolator.Context context = new MessageInterpolatorContext(
                    violation.getConstraintDescriptor(),
                    violation.getInvalidValue(),
                    violation.getRootBeanClass(),
                    violation.getPropertyPath(),
                    Collections.emptyMap(),  // message parameters
                    violation.getConstraintDescriptor().getAttributes(),
                    ExpressionLanguageFeatureLevel.VARIABLES,
                    true
            );

            System.out.println(messageInterpolator.interpolate(
                    violation.getMessageTemplate(),
                    context,
                    new Locale("in", "ID")
            ));
        }
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

