package com.juntralala;

import com.juntralala.singleton.Database;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SinggletonTest {

    @Test
    void singleton() {
        Database database1 = Database.getInstance();
        Database database2 = Database.getInstance();

        Assertions.assertSame(database1, database2);
    }
}
