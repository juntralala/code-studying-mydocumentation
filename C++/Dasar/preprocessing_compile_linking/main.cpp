/*
preprocessing   : g++ -E main.cpp > main.p
compile         : g++ -c main.cpp
                                            objdumb -d main.o          <--- comand untuk menampilkan main.o      (-d artinya disAsamble)
linking         : g++ main.o tambah.o
*/


#include <iostream>

int tambah(int angka1, int angka2);

int main(){
    
    std::cout << tambah(2,2) << std::endl;
    #include "tes_preprocessing_directing.h"

    return 0; 
}