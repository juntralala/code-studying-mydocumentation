# import os
# if __name__ == '__main__':
#     if os.name == 'posix':
#         os.system("clear")
#     elif os.name == 'nt' :
#         os.system("cls")

print("Program Menetukan Positif atau Negatif")
print("*"*35)

try:
    x = int(input("Masukan bilangan : "))

    if x>0:
        print(x," adalah bilangan positif")
    elif x<0:
        print(x," adalah bilangan negatif")
    else:
        print(x,"adalah bukan bilangan")
except:
    print("INVALID INPUT!")

