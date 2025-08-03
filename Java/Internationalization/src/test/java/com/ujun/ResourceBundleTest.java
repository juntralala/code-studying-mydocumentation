package com.ujun;

import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.ResourceBundle;

/** ResourceBundle
 * ResourceBundle adalah class yang digunakan sebagai bundle yang berisikan data yang bisa berubah sesuai
   dengan Locale yang dipilih.
 * ResourceBundle cocok digunakan untuk menyimpan data I18N, dimana semua data akan disimpan dalam sebuah
   properties file
 */

/** Properties File
 * Saat kita menggunakan ResourceBundle, kita perlu membuat properties file di dalam resources sebagai tempat untuk
   ResourceBundle melakukan lookup data
 * Misal kita membuat file properties dengan nama message.properties di dalam resources
 */

/** I18N di ResourceBundle
 * Kode sebelumnya kita hanya menggunakan ResourceBundle sebagai object untuk mengambil data dari properties file,
   kalo seperti ini tidak ada bedanya dengan class Properties
 * Yang membedakan, dalam ResourceBundle, kita bisa melakukan I18N
 * Namun untuk melakukan itu, kita perlu menyediakan properties file sesuai dengan Locale nya
 * Misal jika kita ingin mendukung bahasa in dan negara ID, maka kita perlu membuat message_in_ID.properties.
 * File nya butuh diawali dengan message karena sebelumnya kita menggunakan nama file message.properties
 */

public class ResourceBundleTest {

    @Test
    public void testResourceBundle() {
        Locale locale = new Locale("id", "ID");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("message", locale);
        String hello = resourceBundle.getString("hello");
        System.out.println(hello);
    }
}
