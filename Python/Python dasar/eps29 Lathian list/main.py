import os
os.system('cls')

list_nomor = [1,2,3,4,5,6,7,8,9,10]
print(list_nomor)

list_string = ['Junaidi','Hamdani','arsyad']
print(list_string)

list_boolean = [True,False,True,True]
print(list_boolean)

list_campuran = [1,'Junaidi',2,"Badawi",3,False,4,True]
print(list_campuran)

list_for = [i for i in range(0,5) ]
print(list_for)

list_perpangkatan = [i+1 for i in range(10)]
print(list_perpangkatan)

list_perpangkatan = [i**3 for i in range(10) if i!=0]
print(list_perpangkatan)

list_bilangan_ganjil = [i for i in range(20) if i%2 !=0]
print(list_bilangan_ganjil)

list_bilangan_genap = [i for i in range(0,20,2) if i !=0]
print(list_bilangan_genap)


