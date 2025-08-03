package com.ujun;

import java.util.Formatter;

public class Main {
    public static void main(String[] args) {

        String nama = "Ujun";
        int umur = 18 ;
        System.out.printf("saya %s, umur saya adalah %d\n",nama, umur);

        // Convertion : f=Floting point, d=Integer, c=Character, s=String, b=boolean
        // struktur format = %[argument-index$][flags][width][.precision]conversion

        //  [argument_index$]
        System.out.println("\n[argument_index$]");
        System.out.println("<<" + "=".repeat(20) + ">>");
        // ujun, wahai ujun, kemana saja kamu ujun?
        System.out.printf("%1$s, wahai %1$s, kemana saja kamu %1$s?\n",nama);
        System.out.printf("umur %1$s berapa?  %1$s menjawab : %2$d\n",nama,umur);

        // [flags]
        System.out.println("\n[flags]");
        System.out.println("<<" + "=".repeat(20) + ">>");

        int angka1,angka2,hasil;
        angka1 = 10;
        angka2 = 20;
        hasil  = angka2 - angka1 ;
        System.out.printf("%d -%d = %+d\n",angka2,angka1,hasil);

        // [width]
        System.out.println("\n[width]");
        System.out.println("<<" + "=".repeat(20) + ">>");

        int angka = 1000;
        System.out.println("integer".toUpperCase());
        System.out.printf("%d",angka);
        System.out.printf("\n%8d",angka);
        System.out.printf("\n%-8d",angka);
        System.out.printf("\n%+8d",angka);
        System.out.printf("\n%+-8d",angka);
        System.out.printf("\n%08d",angka);
//      System.out.printf("\n%-08d",angka);   /*INI AKAN ERROR*/
        System.out.printf("\n%+08d",angka);
        System.out.printf("\n%,8d",angka);
        System.out.printf("\n%,08d",angka);
        System.out.printf("\n%,012dn\n\n",angka);

        System.out.print("Floating Point");
        float cacah = 14.4514f ;
        System.out.printf("\n%f",cacah);
        System.out.printf("\n%+15f",cacah);
        System.out.printf("\n%+015f\n",cacah);

        // [.precision]
        System.out.println("\n[.precision]");
        System.out.println("<<" + "=".repeat(20) + ">>");
        float cacah1 = 1.654f ;
        System.out.printf("\n%f",cacah1);
        System.out.printf("\n%.1f",cacah1);
        System.out.printf("\n%.2f",cacah1);
        System.out.printf("\n%06.2f\n",cacah1);

        // contoh :
        String nama2 = "Ipul";
        float IPK = 3.7875f;
        // strukur format = %[argument_index$][flags][width][.precision]convertion
        System.out.printf("\nIPK %1$s berapa?,\n%1$s : saya dapet IPK %2$f\n\n",nama2,IPK);

        // Kesimpulan
        // save format ini kedalam variable string
        String infoBiasa = "Nama : " + nama2 + "\nIPK : " + IPK;
        System.out.println(infoBiasa);

        String infoFormat = String.format("Nama : %1$s\nIPK : %2$.2f",nama2,IPK);
        System.out.println(infoFormat);

        StringBuilder infoBuilder = new StringBuilder();
        Formatter formatBuilder = new Formatter(infoBuilder);

        formatBuilder.format("Nama : %1$s\nIPK : %2$.2f",nama2,IPK);
        System.out.println(infoBuilder);



    }

}
