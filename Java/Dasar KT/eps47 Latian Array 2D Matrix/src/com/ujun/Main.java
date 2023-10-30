package com.ujun;

//import java.util.Arrays;


public class Main {
    public static void main (String[] args) {
        int[][] matrix_a = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int[][] matrix_b = {
                {3,6,9},
                {2,3,8},
                {4,8,12}
        };
        printMatrix(matrix_a);
        printMatrix(matrix_b);

        int[][] hasilPenjumlahan = penjumlahanArray_2d(matrix_a,matrix_b);
        printMatrix(hasilPenjumlahan);

        int[][] matrix_c = {
                {1,2},
                {3,4}
        };
        int[][] matrix_d = {
                {12,20},
                {23,14}
        };

        int[][] hasil = perkalianArray_2d(matrix_a,matrix_b);
        printMatrix(hasil);


    }

    private static void printMatrix(int[][] array_2d) {
        int kolom_a,baris ;
        baris = array_2d.length;
        kolom_a = array_2d[0].length;
        for (int i=0 ; i<baris ; i++) {
            System.out.print("[");
            for (int j = 0; j <kolom_a ; j++) {
                System.out.print(array_2d[i][j]);
                if (j<kolom_a-1) {
                    System.out.print(",");
                } else {
                    System.out.println("]");
                }
            }
        }
            System.out.println();
    }

    private static int[][] penjumlahanArray_2d(int[][] array_2d_1,int[][] array_2d_2) {
        int baris_a = array_2d_1.length;
        int kolom_a = array_2d_1[0].length;

        int baris_b = array_2d_2.length;
        int kolom_b = array_2d_2[0].length;
        int[][] hasil = new int[baris_a][kolom_a];

        if (baris_a == baris_b && kolom_a == kolom_b) {
            for (int i=0 ; i<baris_a ; i++ ) {
                for (int j = 0 ; j<kolom_a ; j++) {
                    hasil[i][j] = array_2d_1[i][j] + array_2d_2[i][j];
                }
            }
        }  else {
            System.out.println("jumlah baris atau kolom tidak sama");
        }
        return hasil;
    }

    private static int[][] perkalianArray_2d(int[][] dataArray_2d_1, int[][] dataArray_2d_2){
        int baris_1,kolom_1,baris_2,kolom_2,buffer;
        baris_1 = dataArray_2d_1.length;
        kolom_1 = dataArray_2d_1[0].length;
        baris_2 = dataArray_2d_2.length;
        kolom_2 = dataArray_2d_2[0].length;
        int[][] hasil = new int[baris_1][kolom_1];

        if ((baris_1 == baris_2) && (kolom_1 == kolom_2)) {
            for (int index = 0; index < baris_1 ; index++) {
                for (int i = 0; i < kolom_1 ; i++) {
                    buffer = 0;
                    for (int j = 0; j < baris_2 ; j++) {
                        buffer += dataArray_2d_1[index][i] * dataArray_2d_2[j][i];
                    }
                hasil[index][i] = buffer ;
                }
            }
        } else {
            System.out.println("Input Invalid jumalh kolom dan baris tidak sama");
        }
        return  hasil;
    }

}





