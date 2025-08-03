import os
from numbers import Number 
os.system("cls")

def tambah(a,b):
    if not isinstance(a,Number) or not isinstance(b,Number):
        raise "input harus angka"
    return a+b

print(tambah(1,3))

angka = 0

try:
    hasil = 10/angka
except ZeroDivisionError as error_message:
    print(error_message)