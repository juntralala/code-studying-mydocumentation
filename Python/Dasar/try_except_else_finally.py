''' bentuk lengkap error handling
=> try statement    : program akan mencoba menjalankan blok kode yang mungkin terjadi pengecualian.
=> except statement : program akan mengeksekusi statement ini jika terjadi pengecualian.
=> else statement   : program akan mengeksekusi statement ini jika tidak terjadi pengecualian.
=> finally statement: program akan mengeksekusi statement ini setelah semua pernyataan di atas terjadi.
'''

var_dict = {"rata_rata": "1.0"}

try:
    print(f"rata-rata adalah {var_dict['rata_rata']}")
except KeyError:
    print("Key tidak ditemukan.")
except TypeError:
    print("Anda tidak bisa membagi nilai dengan tipe data string")
else:
    print("Kode else dieksekusi jika tidak ada exception.")
finally:
    print("Kode finally ini dieksekusi terlepas dari ada atau tidaknya exception.")