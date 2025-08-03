from . import operasi  

dataBaseName = "data.txt"

template = {
    "pk"      : "XXXXXX",
    "tanggal_ditambahkan" : ""*20,
    "penulis" : " "*255,
    "judul"   : " "*255,
    "tahun"   : "DDDD"*4
}

def init_console():
    try:
        with open(dataBaseName,"r") as file:
            pass
    except:
        print("dataBase tidak ditemukan")
        print("Masukkan data baru")
        operasi.create_first_data()

import time

waktu = time.time()
