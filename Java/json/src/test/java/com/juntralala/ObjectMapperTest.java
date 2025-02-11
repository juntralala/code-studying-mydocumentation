package com.juntralala;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

/** ObjectMapper
 * ObjectMapper adalah class di library Jackson sebagai class utama
 * Untuk menggunakan library Jackson, kita perlu membuat object ObjectMapper
 * ObjectMapper hanya perlu dibuat sekali, dan bisa digunakan berkali-kali, tanpa harus takut dengan race condition, karena sudah thread safe
 */

public class ObjectMapperTest {

    @Test
    void createMapper() {
        ObjectMapper mapper = new ObjectMapper();
    }
}
