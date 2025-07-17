'''
-> JSON adalah format pertukaran data ringan yang digunakan untuk merepresentasikan dan mentransmisikan
   data terstruktur
=> JSON secara default hanya dapat merepresentasikan subset dari built-in type pada Python.
=> agar sebuah object dari class yang kita buat bisa dikonversi menjadi json harus membuat method __dict__,
   kalau sudah kita tinggal masukkan object kita kefunction json.dump(object_kita)
'''
