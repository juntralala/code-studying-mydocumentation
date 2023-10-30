package uuid;

import java.util.UUID;

/**
 * saat mebuat aplikasi, terkadang ada kasus kita ingin membuat data unique, misalnya untuk kebutukan primary key
 *
 * Java menyediakan class UUID atau singkatan dari Universally Unique Identifier
 *
 * UUID adalah format standard unutk membuat unique value yang tekah terjamin
 */

public class UUIDApp {
    public static void main(String[] args) {

        for (var i = 0; i<25 ; i++) {
            UUID id = UUID.randomUUID();
            String key = id.toString();

            System.out.println(key);
        }
    }
}
