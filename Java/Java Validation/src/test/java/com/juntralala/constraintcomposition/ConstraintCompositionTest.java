package com.juntralala.constraintcomposition;

import com.juntralala.MyTest;
import com.juntralala.constraintcomposition.data.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConstraintCompositionTest extends MyTest {

    @Test
    public void constraintComposition() {
        var order = new Order();
        order.setId("A0001");
        order.setAmount(100_000L);

        var violations = validator.validate(order);

        printViolationsInfo(violations);
        Assertions.assertEquals(1, violations.size());
    }

}
