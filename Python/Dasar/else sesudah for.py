
'''Else setelah For
=> Pada Python juga dikenal else setelah for yang berfungsi untuk perulangan bersifat pencarian. Else
   setelah for ini bisa dikatakan sebagai memberikan jalan keluar program saat pencarian tidak ditemukan.
'''
numbers = [1, 2, 3, 4, 5]

for num in numbers:
    if num == 5:
        print("Angka ditemukan! Program berhenti!")
        break
else:
    print("Angka tidak ditemukan.")
    
'''
=> Perlu diperhatikan oleh Anda, if dan else pada contoh tersebut berkaitan walaupun berbeda blok.
   Pada else setelah for, statement else tidak akan dieksekusi saat if pernah sekali saja benar. Dengan
   kata lain, break dalam if harus tidak terjadi untuk memicu else setelah for.
'''