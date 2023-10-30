from os import system
system("cls")

panjang = int(input('Masukan panjang\t: '))
lebar = int(input('Masukan lebar\t: '))

luas = panjang * lebar
keliling = 2 * (panjang + lebar)

print(f"Luas\t\t: {luas}\nKeliling\t: {keliling}")