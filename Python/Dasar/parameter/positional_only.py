# <=============== Positional Parameter Only ===============>

def sum(angka1, angka2, /):
    return angka1 + angka2

print(sum(2, 3))
# print(sum(angka1=1, angka2=2)) # akan terjadi error jika memaksa memanggil function dengan keyword paramter