import os

os.system("cls")

print(f"<<{'Membaca file TXT'.center(40,'=')}>>")
file = open("file.txt",mode="+r")

print(f"status read : {file.readable()}")
print(f"status write : {file.writable()}")

print(file.read())
file.write("Nama saya Muhammad Junaidi")

# print(file.readline())
# print(file.readline())
# print(file.readline())
# print(file.readline())

# print(file.readlines())
print(f"apakah file sudah diclose : {file.closed}")
file.close()
print(f"apakah file sudah diclose : {file.closed}\n")

print(f"<<{'Membaca file TXT dengan with'.center(40,'=')}>>")

with open("file.txt",mode="r") as file :
    print(f"status read : {file.readable()}")
    print(f"status write : {file.writable()}")
    print(f"apakah file sudah diclose : {file.closed}")

print(f"apakah file sudah diclose : {file.closed}")
nama ="s"














