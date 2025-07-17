# <=============== Positional Parameter or Keyword Paramter ===============>

def sum(angka1, angka2):
    return angka1 + angka2

hasil = sum(1 ,2) # meletakkan argument sesuai urutan parameter
print(hasil)

hasil = sum(angka2=4, angka1=2) # <- ini keyword parameter 
print(hasil)
