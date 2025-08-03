""" informasi tambahan tentang sort
1. Sort bisa melakukan reverse dengan cara
"""

kendaraan = ['motor', 'mobil', 'helikopter', 'pesawat']
print(kendaraan.sort(reverse=True))
print(len(kendaraan))

"""
2. sort tidak bisa mengurutkan list atau set yang memiliki angka dan string sekaligus didalamanya
    jika tetap dilakukan maka akan terjadi error
3. sort() menggunakan urutan ascii code untuk mengurutkan data sehingga huruf besar akan didahulukan dulu sebelum huruf kecil
"""


