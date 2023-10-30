import os
os.system("cls")

# try :
#     file = open("data.txt","r")
# except :
#     print("file tidak ditemukan, membuat file baru")
#     file = open("data.txt","w")
#     file.write("")

while True :
    angka = int(input("masukan angka : "))
    try:
        hasil = 10/angka
        print("hasil : ",hasil)
    except:
        print("angka yang dimasukkan tidak boleh nol")
    if input("Mulai ulang program[y/n]? ")=="n":
        break
print("Akhir program")

while True:
    try:
        with open("data.txt","r") as file:
            print(file.read())
            break
    except:
        print("file tidak ditemukan, membuat file baru")
        with open("data.txt","w",encoding="utf-8") as file:
            file.write("nice")
        if input("ulangi program[y/n]? ")=="n":
            break
print("Akhir program2")



 
