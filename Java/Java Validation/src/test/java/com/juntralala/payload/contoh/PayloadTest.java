package com.juntralala.payload.contoh;

import com.juntralala.MyTest;
import org.junit.jupiter.api.Test;

public class PayloadTest extends MyTest {

    @Test
    void testPayload() {
        var payment = new Payment("A001", 2_000_000L, "invalid credit card", "");
        var violations = validator.validate(payment);

        violations.forEach(violation -> {
            violation.getConstraintDescriptor().getPayload().forEach(payload -> {
                if (payload == EmailErrorPayload.class) {
                    EmailErrorPayload emailErrorPayload = new EmailErrorPayload();
                    emailErrorPayload.sendEmail(violation);
                }
            });
        });
    }

}
