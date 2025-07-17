package com.juntralala.valueextraction;

import com.juntralala.MyTest;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.valueextraction.ExtractedValue;
import jakarta.validation.valueextraction.ValueExtractor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ValueExtractionTest extends MyTest {

    @Test
    void valueExtraction() {
        ValidatorFactory factory = Validation.byDefaultProvider()
                .configure()
                .addValueExtractor(new DataValueExtractor())
                .buildValidatorFactory();
        Validator validator = factory.getValidator();

        Sample sample = new Sample(new Data<String>());

        var violations = validator.validate(sample);
        printViolationsInfo(violations);
        Assertions.assertEquals(1, violations.size());
    }
}

@AllArgsConstructor
@Getter
@Setter
class Sample {

    private Data<@NotBlank @Size(min = 10) String> data;

    public Data<String> getData() {
        return data;
    }
}

class Data<T> {
    private T data;

    public T getData() {
        return data;
    }
}

class DataValueExtractor implements ValueExtractor<Data<@ExtractedValue ?>> {

    @Override
    public void extractValues(Data<?> data, ValueReceiver valueReceiver) {
//        System.out.println(Arrays.toString(data.getClass().getTypeParameters()));
        valueReceiver.value(null, data.getData());
    }
}
