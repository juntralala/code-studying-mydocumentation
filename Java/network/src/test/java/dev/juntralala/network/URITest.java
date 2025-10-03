package dev.juntralala.network;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * instanciate URI dengan constructor yang schemenya terpisah dengan bagian uri lain akan melakukan escape character otomatis untuk special character atau character invalid di uri
 */
public class URITest {

    @Test
    public void createInstance() {
        assertDoesNotThrow(() -> {
            URI uri = URI.create("/hello");
        });
    }

    @Test
    @DisplayName("Creation uri error cause of contains space")
    public void createInstanceErrorAsContainsSpace() {
        assertThrows(IllegalArgumentException.class, () -> {
            URI uri = URI.create("/hello bro");
        });
    }

    @Test
    @DisplayName("Creation uri error cause of contains more than one fragments")
    public void createInstanceErrorAsMoreOneFragments() {
        assertThrows(IllegalArgumentException.class, () -> {
            URI uri = URI.create("/hello#sapa#name");
        });
    }

    @Test
    public void constructorOneStringArg() {
        assertDoesNotThrow(() -> {
            new URI("https://youtube.com");
            new URI("/hello");
            new URI("hello");
        });
    }

    @Test
    public void constructorThreeStringArg() {
        assertDoesNotThrow(() -> {
            var uri = new URI("http", "//localhost:80/hello?name=jun tralala", "hello");
            System.out.println(uri);
        });
    }

    @Test
    public void constructorThreeStringArgFragmentNull() {
        assertDoesNotThrow(() -> {
            var uri = new URI("http", "//localhost:80/hello?name=jun tralala", null);
            System.out.println("uri = " + uri);
            new URI(null, "hello", null);
        });
    }

    @Test
    public void constructorFourStringArg() {
        assertDoesNotThrow(() -> {
            // can not put port in here, just use another constructor for change default port
            // cannot put query url, the symbol ? will be encoded to url entity
            var uri = new URI("http", "localhost", "/hello bro", "sapa");
            System.out.println("uri = " + uri);
        });
    }

    @Test
    public void constructorFiveStringArg() {
        assertDoesNotThrow(() -> {
            var uri = new URI("http", "localhost:8080", "/hello", "name=jun tralala", "sapa");
            System.out.println("uri = " + uri);
        });
    }

    @Test
    public void constructorSevenStringArg() {
        assertDoesNotThrow(() -> {
            var uri = new URI("http", "ujun", "localhost", 8080, "/hello", "name=jun tralala", "sapa");
            System.out.println("uri = " + uri);
            System.out.println("authority = " + uri.getAuthority());
        });
    }

    @Test
    public void constructorSevenStringArgUserNull() {
        assertDoesNotThrow(() -> {
            var uri = new URI("http", null, "localhost", 8080, "/hello", "name=jun tralala", "sapa");
            System.out.println("uri = " + uri);
            System.out.println("authority = " + uri.getAuthority());
        });
    }

    @Test
    @Order(1000)
    public void scanAllUriMethodWithoutArg() throws URISyntaxException {
        List<String> unCalledMethods = new ArrayList<>();
        var uri = new URI("http", "user:password", "localhost.com", 8080, "/sapa orang/siang", "name=jun tralala&state=123", "sapa orang");
        for (Method method : uri.getClass().getMethods()) {
            try {
                System.out.println(method.getName() + " => " + method.invoke(uri));
            } catch (Throwable e) {
                unCalledMethods.add(method.getName());
            }
        }
        System.out.println("uncalled: " + unCalledMethods);
    }

    @Test
    public void testResolve() {
        var base = URI.create("http://localhost/api/?key=anu");
        var relative = URI.create("hello?name=saya");
        var result = base.resolve(relative);
        System.out.println(result);

        System.out.println(URI.create("/hello/apa").resolve(base));
        System.out.println(base.resolve(URI.create("hello/apa")));

        System.out.println(base.resolve("http://localhost:8080/hello"));

        // kalau lupa, baca dokumentasi java URI untuk 2 dibawah ini
        System.out.println(URI.create("http://localhost:"));
        System.out.println(URI.create("file:///temp"));
    }
}
