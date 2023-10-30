package properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * kebanyakan aplikasi java akan menyimpan konfigurasi file dalam bentuk properties file
 *
 * properties file adalah file yang berisi key value yang dipesahkan tanda sama denagn(=)
 *
 * properties file bisa kia gunakan untuk menyimpan konfigurasi aplikasi kita
 *
 * Propertes class adalah class yang digunakan untuk menambil atau menyimpan informasi kefile properties
 */

public class PropertiesApp  {
    public static void main(String[] args) {

        Properties prop = new Properties();

        try {
            prop.load(new FileInputStream("properties/data.properties"));
            //menambil data
            String host = prop.getProperty("database.host");
            String user = prop.getProperty("database.username");
            String pass = prop.getProperty("database.password");
            String fullName = prop.getProperty("name.first") + " " + prop.getProperty("name.last");

            System.out.println(host);
            System.out.println(user);
            System.out.println(pass);
            System.out.println(fullName);

        } catch (FileNotFoundException e) {
            System.out.println("File tidak di temukan");
        } catch (IOException e) {
            System.out.println("Gagal Load Data dari File");
        }

        try {
            prop.load(new FileInputStream("properties/data.properties"));

            // menyimpan data
            prop.put("saya.nama", "Muhammad Junaidi");
            prop.put("saya.umur", "18");
            prop.put("saya.perkerjaan", "Mahasiswa");

            prop.store(new FileOutputStream("properties/myData.properties"), "");

        } catch (FileNotFoundException e) {
            System.out.println("File tidak di temukan");
        } catch (IOException e) {
            System.out.println("Gagal Load Data dari File");
        }
    }
}
