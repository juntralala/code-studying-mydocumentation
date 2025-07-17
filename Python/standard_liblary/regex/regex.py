'''
Regex atau regular expression adalah sebuah cara untuk mencari teks berdasarkan pola tertentu.
Untuk menggunakan Regex di python kita bisa mengimport module re 
'''

import re

pattern = 'M.*d$' # $ untuk mencari akhiran
str_tes = "Muhammad"
hasil = re.match(pattern, str_tes)

if hasil:
    print("pencarian berhasil")
else:
    print("pencarian gagal")

