package com.ujun;

import org.junit.jupiter.api.Test;

/**
 * Tambahan tipe dan style pada pattern untuk Message Format
 *  MessageFormatPattern:
            String
            MessageFormatPattern FormatElement String

 *  FormatElement:
            { ArgumentIndex }
            { ArgumentIndex , FormatType }
            { ArgumentIndex , FormatType , FormatStyle }

 *  FormatType: one of
            number date time choice

 *  FormatStyle:
            short
            medium
            long
            full
            integer
            currency
            percent
            SubformatPattern
 */

import java.text.MessageFormat;

public class MessageFormatTest {

    @Test
    public void messageFormat(){
        String pattern = "Hai {0}, Bagaimana kabarmu dihari yang {1} ini";
        MessageFormat messageFormat = new MessageFormat(pattern);
        String message = messageFormat.format(new Object[]{"Adit", "Cerah"});

        System.out.println(message);
    }
}
