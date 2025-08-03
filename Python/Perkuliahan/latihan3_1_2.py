# import os
# if __name__ == '__main__':
#     if os.name == 'posix':
#         os.system("clear")
#     elif os.name == 'nt' :
#         os.system("cls")

print("Program Menentukan Bilangan yang Terbesar")
print("*"*41)

a = int(input("Masukan bilangan ke 1 = "))
b = int(input("Masukan bilangan ke 2 = "))
c = int(input("Masukan bilangan ke 3 = "))

print()

if (a>b) and (a>c):
    print("Bilangan ke 1 paling besar")
elif (b>a) and (b>c):
    print("Bilangan ke 2 paling besar")
elif (c>b) and (c>a):
    print("Bilangan ke 3 paling besar")
else:
    print("ada 2 atau 3 masukan bernilai sama")