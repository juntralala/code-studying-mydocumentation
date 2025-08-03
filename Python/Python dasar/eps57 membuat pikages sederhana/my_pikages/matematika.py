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

def waktu_tempuh(kecepatan,jarakTempuh):
    return jarakTempuh/kecepatan*60

def jarak_tempuh(kecepatan,waktuJamTempuh,waktuMenitTempuh=0):
    return (kecepatan*waktuJamTempuh)+(kecepatan*waktuMenitTempuh/60)