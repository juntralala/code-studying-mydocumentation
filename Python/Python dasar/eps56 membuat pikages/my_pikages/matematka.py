def tambah(*angka:int)->int:
    hasil = 0
    for nilai in angka:
        hasil += nilai
    return hasil

def kali(*angka:int)->int:
    hasil = 0
    for nilai in angka:
        hasil *= nilai
    return hasil

def pangkat(n:int)->int:
    return lambda nilai:nilai**n


