import os
os.system('cls')

def pangkat_2(angka):
    return angka**2
hasil=pangkat_2(2)
print(f"hasil fungtion biasa {hasil}")
#lambda function
hasil = lambda angka:angka**2
print(f"hasil pangkat 2 lambda function {hasil(2)}")
nama = ['ujun','ilham','hamdani','yazid']
print(nama)

def sortir(s):
    return len(s)

nama.sort(key=lambda x:len(x))
print(nama)

data_angka = [1,2,3,4,2,6,4,7,4,9,5,4,7,1,6,0,4]
# def sortir(s):
#     return s<5
data_angka_sorted = list(filter(lambda x:x<5,data_angka))
print(data_angka_sorted)
nama_filtered = list(filter(lambda x:len(x)<6,nama))
print(nama_filtered)

#anonymous function

def pangkat(n):
    return lambda angka:angka**n
hasil = pangkat(2)
print(hasil(6))

 
