import os
os.system('cls')

def fungsi_header():
    print("LATIHAN FUNGSI".center(50))
    print("PENGHITUNGAN LUAS DAN KELILING PERSEGI PANJANG".center(50))
    print(f"<{'='*48}>")

def fungsi_input():
    panjang = int(input('Masukkan nilai panjang : '))
    tinggi = int(input('Masukkan nilai tinggi  : '))
    return panjang,tinggi

def fungsi_luas(panjang,tinggi):
    return panjang*tinggi
def fungsi_keliling(panjang,tinggi):
    return panjang*2+tinggi*2

def fungsi_display(massage,hasil):
    print(f"Hasil perhitungan {massage} \t: {hasil}")

while True:
    os.system('cls')
    fungsi_header()
    pilih_operator = input('Menghitung luas(1) atau keliling(2)? ')
    if pilih_operator=='1' or pilih_operator=='luas' or pilih_operator=='LUAS' or pilih_operator=='Luas':
        panjang,tinggi = fungsi_input()
        fungsi_display('Luas',fungsi_luas(panjang,tinggi))
    elif pilih_operator=='2' or pilih_operator=='keliling' or pilih_operator=='KELILING' or pilih_operator=='Keliling':
        panjang,tinggi = fungsi_input()
        fungsi_display('Kelling',fungsi_keliling(panjang,tinggi))
    else :
        print('Masukin input yang bener dong, aku pusying!!')

    isContinue = input('Lanjut ? (y/n)') 
    if isContinue=='y' :
        continue
    else :
        break

