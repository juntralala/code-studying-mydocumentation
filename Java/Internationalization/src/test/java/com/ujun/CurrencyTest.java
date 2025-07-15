package com.ujun;

import org.junit.jupiter.api.Test;

import java.util.Currency;
import java.util.Locale;

public class CurrencyTest {

    @Test
    public void testCreateCurrency(){
        Locale locale = new Locale("id", "ID");
        Currency currency = Currency.getInstance(locale);

        System.out.println(currency.getCurrencyCode());
        System.out.println(currency.getSymbol());
        System.out.println(currency.getDisplayName());
    }
}
