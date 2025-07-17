package com.juntralala.payload.contoh;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Payload;

class EmailErrorPayload implements Payload {

    public void sendEmail(ConstraintViolation<?> constraint) {
        System.out.println("Send email because error: " + constraint.getMessage());
    }

}
