import os
os.system('cls')

angka = [5,2,3,7,4,8,1,4,3]

for i in angka :
    print('anka = %s' %i)

nama = ['ujun','dayat','alia','arif','rahmi','ajid']
for i in nama :
    print(f'nama = {i}')

panjang = len(angka)
for i in range(panjang) :
    print(f'i => {i} = {angka[i]}')

panjang = len(nama)
i =0
while i<panjang :
    print(f'nama := {i} => {nama[i]}')
    i += 1

#list coparehension
[print(f'nama : {i}' )for i in nama ]

for index,data in enumerate(nama) :
    print(f'index : {index}   data : {data}')

angka_kuadrat =[i**2 for i in angka]

input()