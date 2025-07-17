import os
os.system('cls')
from copy import deepcopy

list_buku = []
jumlah_input = int(input('Berapakali input? '))
i = 0

while i<jumlah_input :
    i += 1
    nama_buku_baru = input('Nama buku baru \t\t: ')
    pengarang_buku = input('Pengarang buku baru \t: ')

    buku_baru = [nama_buku_baru,pengarang_buku]
    list_buku.append(buku_baru)

print("+====+==============================+========================+")
print("| No |          Nama Buku           |  nama pengarang buku   |")
print("+----+------------------------------+------------------------+")
for i,data in enumerate(list_buku) :
    print(f"|{str(i).center(4)}|{data[0].center(30)}|{data[1].center(24)}|")
print("+====+==============================+========================+")
input()