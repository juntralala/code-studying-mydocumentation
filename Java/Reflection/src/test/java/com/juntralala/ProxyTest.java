package com.juntralala;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* Proxy
Saat kita belajar di kelas Java Unit Test, kita belajar dengan yang namanya stub, yaitu object tiruan
Java Reflection memiliki fitur yang bernama Proxy
Proxy bisa digunakan untuk membuat object bahkan tanpa harus membuat implementasi sebuah Interface
Terlihat aneh, tapi fitur ini sangat berguna pada kasus-kasus tertentu, bahkan saat ini populer yang namanya Spring Data yang bisa digunakan untuk memanipulasi  database cukup bermodalkan Interface, tanpa harus membuat implementasi class dan melakukan query database secara manual
https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/reflect/Proxy.html
 */

/** Invocation Hanler
 * Saat kita membuat  proxy, kita bisa secara dinamis menerima method yang dipanggil, dan mengembalikan value di method tersebut dengan InvocationHandler
 * Fitur ini dalam bahasa pemrograman lain mirip sekali dengan yang namanya Meta Programming
 * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/reflect/InvocationHandler.html
 */

public class ProxyTest {


    @Test
    public void testProxy() throws NoSuchMethodException {
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("getName")) {
                    return "Car Proxy";
                } else if (method.getName().equals("run")) {
                    System.out.println("Proxy Car is running...");
                }

                return null;
            }
        };

        Car car = (Car) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{Car.class},
                invocationHandler
        );

        System.out.println(car.getName());
        car.run();
    }

}
