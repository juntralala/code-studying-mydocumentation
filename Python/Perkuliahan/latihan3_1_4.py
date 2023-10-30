# import os
# if os.name == "posix":
#     os.system("clear")
# elif os.name == "nt":
#     os.system("cls")
    
print("\nProgram Menghitung Luas")
print("*"*23)
print("")
print("Pilih Menu")
print("=============> 1. Luas Lingkaran")
print("             2. Luas Persegi")
print("             3. Luas Segitiga")
print("")
pilihan = int(input("Masukan pilihan = "))
print("")

if pilihan == 1:
    print("Program Lingkaran")
    print("******************")
    print("")
    jari = int(input("Masukan jari-jari = "))
    luas = 3.14 * (jari * jari)
    print("Luas adalah : %.2f"%luas)
elif pilihan == 2:
    print("Program Persegi Panjang")
    print("=======================")
    print("")
    panjang = int(input("Masukan Panjang = "))
    lebar = int(input("Masukan Lebar = "))
    luas = panjang * lebar
    print("Luas adalah :", luas)
elif pilihan == 3:
    print("Program Segitiga")
    print("================")
    print("")
    a = int(input("Masukan alas = "))
    t = int(input("Masukan tinggi = "))
    luas = 0.5 * a * t
    print("Luas adalah : ",luas)
else:
    print("Pilihan Menu Tidak Ada")
    