package com.ujun;

public class Main {
    public static void main (String[] args){
        // deret fibonaci
        double kuadrat =  Math.pow(2d,40d);
        System.out.printf("Hasil Kuadrat : %.2f\n",kuadrat);
        long nilaiFibonacci = prosesDeretFibbonaci(40);
        System.out.print("Nilai fibonacci : "+ nilaiFibonacci);

    }

    private static int prosesDeretFibbonaci(int n){
        if (n <= 1) {
            return n;
        } else {
            return prosesDeretFibbonaci(n-1) + prosesDeretFibbonaci(n-2);
        }
    }
}
