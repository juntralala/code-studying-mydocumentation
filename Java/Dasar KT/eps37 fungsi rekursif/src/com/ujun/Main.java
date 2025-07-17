package com.ujun;
import java.util.Arrays;
public class Main {

    public static void main(String[] args){

        string();
        int deretaritmatika = deretAritmatika(1,0);
        System.out.println("deret ke 20 : "+ deretaritmatika);

    }

    public static void string(){

        int angka1 = 5;
        int[] angka = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(angka));



    }

    private static int deretAritmatika(int input,int counter){
        System.out.println("deret ke"+  ++counter +" : " + input);
        if (counter == 20 ){
            return input;
        }
        return deretAritmatika(input,counter) +2 ;
    }

}
