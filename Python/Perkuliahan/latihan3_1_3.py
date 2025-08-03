# import os
# if os.name == 'nt':
#     os.system("cls")
# elif os.name == "posix":
#     os.system("clear")
    
print("Program Seleksi Ganjil atu Genap")
print("*"*32)

bilangan = int(input("Masukan bilangan ke 1 = "))
print()

if bilangan %2 == 1:
    print(bilangan,"adalah bilangan ganjil")
elif bilangan == 0:
    print(bilangan,"adalah bukan ganjil atau genap karna bukan bilangan")
else:
    print(bilangan,"adalah bilangan genap")
