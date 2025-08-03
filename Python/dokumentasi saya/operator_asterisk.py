"""
operator asterisk bisa juga disebut operator *args atau unpacking
"""

def tambah(*args) :
    total = 0
    for val in args:
        total += val
    return total

angka = [4, 6, 8, 2]
hasil = tambah(*angka)
print(hasil)