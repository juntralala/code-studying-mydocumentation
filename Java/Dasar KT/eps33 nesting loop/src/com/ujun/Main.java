package com.ujun;

public class Main {

    public static void main(String[] arg){

        for (int i=1 ; i<=5 ; i++){
            for (int counter=5-i+1 ; counter>0 ; counter--){
                System.out.print("   ");
            }
            for (int index=1 ; index <=i ; index++){
                System.out.print("*  ");
            }
            for (int index=1 ; index<=i;index++){
                System.out.print("*  ");
            }
        System.out.println();
        }

        for (int i =1; i<=5 ; i++){
            for (int counter=1 ; counter<i+1 ; counter++){
                System.out.print("   ");
            }
            for (int index=1 ; index <=5-i+1 ; index++){
                System.out.print("*  ");
            }
            for (int index=1 ; index<=5-i+1;index++){
                System.out.print("*  ");
            }
        System.out.println();
        }


    }

}
