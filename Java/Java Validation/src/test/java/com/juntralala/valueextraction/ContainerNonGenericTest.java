package com.juntralala.valueextraction;

import com.juntralala.MyTest;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.Min;
import jakarta.validation.valueextraction.ExtractedValue;
import jakarta.validation.valueextraction.UnwrapByDefault;
import jakarta.validation.valueextraction.ValueExtractor;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContainerNonGenericTest extends MyTest {

    @Test
    void containerNonGeneric() {
        ValidatorFactory factory = Validation.byDefaultProvider()
                .configure()
                .addValueExtractor(new DataIntegerValueExtractor())
                .buildValidatorFactory();
        Validator validator = factory.getValidator();
        SampleDataInteger sample = new SampleDataInteger(1);

        var violations = validator.validate(sample);

        printViolationsInfo(violations);
        Assertions.assertEquals(1, violations.size());
    }
}

class SampleDataInteger {
    @Min(value = 10)
    private DataInteger dataInteger;

    public SampleDataInteger(Integer data) {
        dataInteger = new DataInteger();
        dataInteger.setData(data);
    }
}

@Getter
@Setter
class DataInteger {
    private Integer data;
}

@UnwrapByDefault        // <- jangan sampai lupa menambahkan
class DataIntegerValueExtractor
        implements ValueExtractor<@ExtractedValue(type = Integer.class) DataInteger> {
    @Override
    public void extractValues(DataInteger originalValue, ValueReceiver valueReceiver) {
        valueReceiver.value(null, originalValue.getData());
    }
}
