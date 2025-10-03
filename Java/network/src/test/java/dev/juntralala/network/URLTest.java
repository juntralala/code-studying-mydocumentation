package dev.juntralala.network;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

/**
 * Sejak java 20, semua constructor URL sudah deprecated, lebih desarankan menggunakan URI.toURL()
 */
public class URLTest {

    @Test
    public void openConnect() throws IOException { // with http get method
        URL url = URI.create("http://localhost:8080/hello").toURL();
        URLConnection urlConnection = url.openConnection();
        String data = new String(urlConnection.getInputStream().readAllBytes());
        System.out.println(data);
    }

    @Test
    public void openConnectPost() throws IOException { // with http post method
        URL url = URI.create("http://localhost:8080/sapa").toURL();
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setDoOutput(true); // <- automatically change method to POST
        OutputStream outputStream = urlConnection.getOutputStream();
        outputStream.write("ujun".getBytes());
        String data = new String(urlConnection.getInputStream().readAllBytes());
        urlConnection.disconnect();
        System.out.println(data);
    }

    @Test
    public void localFile() throws IOException {
        URL fileUrl = URI.create("file:pom.xml").toURL();
        URLConnection urlConnection = fileUrl.openConnection();
        InputStream inputStream = urlConnection.getInputStream();

        String data = new String(inputStream.readAllBytes());
        System.out.println(data);
    }

    @Test
    public void test() throws MalformedURLException {
        var uri1 = URI.create("http://localhost:8080");
        var uri2 = URI.create("http://127.0.0.1:8080");

        System.out.println(uri1.equals(uri2));

        var url1 = uri1.toURL();
        var url2 = uri2.toURL();
        System.out.println(url1.equals(url2));
    }

}
