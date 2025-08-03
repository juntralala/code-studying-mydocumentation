# <=============== Keyword Paramter parameter ===============>

def sum(*, angka1, angka2):
    return angka1 + angka2

print(sum(angka1=2, angka2=3))
# print(sum(3, 3)) # kalau memaksa mengirim positional parameter akan terjadi error