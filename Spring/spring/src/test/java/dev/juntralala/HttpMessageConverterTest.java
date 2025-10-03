package dev.juntralala;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.lang.NonNull;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

public class HttpMessageConverterTest {

    public static class StringToDateConverter implements HttpMessageConverter<LocalDateTime> {

        @Override
        public boolean canRead(Class<?> clazz, MediaType mediaType) {
            return false;
        }

        @Override
        public boolean canWrite(Class<?> clazz, MediaType mediaType) {
            return false;
        }

        @Override
        @NonNull
        public List<MediaType> getSupportedMediaTypes() {
            return List.of(
                    MediaType.TEXT_PLAIN
            );
        }

        @Override
        @NonNull
        public LocalDateTime read(@NonNull Class<? extends LocalDateTime> clazz,@NonNull HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {

            return LocalDateTime.now();
        }

        @Override
        public void write(@NonNull LocalDateTime dateTime, MediaType contentType,@NonNull HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {

        }
    }

    @Test
    public void test() {
        new HttpMessageConverters(List.of());
    }
}
