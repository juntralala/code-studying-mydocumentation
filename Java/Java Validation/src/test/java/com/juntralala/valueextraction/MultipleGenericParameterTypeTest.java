package com.juntralala.valueextraction;

import com.juntralala.MyTest;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.valueextraction.ExtractedValue;
import jakarta.validation.valueextraction.ValueExtractor;
import lombok.Data;
import org.junit.jupiter.api.Test;

public class MultipleGenericParameterTypeTest extends MyTest {

    @Test
    void multipleGenericParameterType() {
        ValidatorFactory factory = Validation.byDefaultProvider()
                .configure()
                .addValueExtractor(new KeyEntryValueExtractor())
                .addValueExtractor(new ValueEntryValueExtractor())
                .buildValidatorFactory();
        Validator validator = factory.getValidator();

        var singleMap = new SingleMap();
        singleMap.put("", null);

        var violations = validator.validate(singleMap);
        printViolationsInfo(violations);
    }

}

class SingleMap {

    private Entry<@NotBlank String,@NotBlank String> entry= new Entry<>();

    public void put(String key, String value) {
        entry.setKey(key);
        entry.setValue(value);
    }

    public String get(String key) {
        return entry.getKey().equals(key) ? entry.getValue() : null;
    }
}

@Data
class Entry<K, V> {
    private K key;
    private V value;
}

class KeyEntryValueExtractor implements ValueExtractor<Entry<@ExtractedValue ?, ?>> {
    @Override
    public void extractValues(Entry<?, ?> entry, ValueReceiver valueReceiver) {
        valueReceiver.keyedValue("<entry key>", entry.getKey(), entry.getKey());
    }
}

class ValueEntryValueExtractor implements ValueExtractor<Entry<?, @ExtractedValue ?>> {
    @Override
    public void extractValues(Entry<?, ?> entry, ValueReceiver valueReceiver) {
        valueReceiver.keyedValue("<entry value>", entry.getKey(), entry.getKey());
    }
}