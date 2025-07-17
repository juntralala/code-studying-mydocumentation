# <=============== Pariadic Keyword Parameter ===============>
def sum(**kwargs):
    hasil = 0
    for key, val in kwargs.items():
        hasil += val
        print(f"value dari key '{key}' ditambahkan")
    return hasil


hasil = sum(angka1=2, angka2=4, a=1, nomor=3)
print(hasil)
