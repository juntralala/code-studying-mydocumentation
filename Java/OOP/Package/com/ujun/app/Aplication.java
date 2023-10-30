package Package.com.ujun.app;

import Package.com.ujun.data.Product;

public class Aplication {
    public static void main(String[] args) {

        Product laptop = new Product("HP X360", 9_700_000);
        System.out.println("Produk name  : " + laptop.name);
        System.out.println("Produk price : " + laptop.price);

    }
}
