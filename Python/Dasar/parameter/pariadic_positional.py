# <=============== Pariadic Positional Parameter ===============>

def sum(*args):
    hasil= 0
    for val in args:
        hasil += val
    return hasil

hasil = sum(1, 2, 3, 4, 5)
print(hasil)