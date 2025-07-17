import os
import datetime as dt
os.system('cls')

loop = int(input('Berapa kali memasukkan data nahasiswa? '))

mahasiswa_template = {
    'nama' : '',
    'nim'  : '',
    'lahir': dt.date(2000,2,22),
    'sks_lulus': ''
}
list_mahasiswa = []

for i in range(loop) :
    os.system('cls')
    print(f"{'Selamat datang mahasiswa'.upper():^50}")
    print(f'<{"="*48}>')
    mahasiswa_template['nama'] =      input('Masukkan nama              : ')
    mahasiswa_template['nim'] =       input('Masukkan NIM               : ')
    tanggal_lahir =                   input('Tanggal Lahir (yy-yy-yyyy) : ')
    mahasiswa_template['sks_lulus'] = input('SKS yang telah Terpenuhi   : ')

    tanggal_lahir_list = tanggal_lahir.split('-',2)
    mahasiswa_template['lahir'] = dt.date(int(tanggal_lahir_list[2]),int(tanggal_lahir_list[1]),int(tanggal_lahir_list[0]))
    list_mahasiswa.append(mahasiswa_template.copy())

print(f"<{'DATA MAHASISWA'.center(60,'=')}>")
print(f"+====+{'='*20}+{'='*12}+{'='*18}+{'='*6}+")
print(f"| No |{'Nama':^20}|{'NIM':^12}|{'Tanggal Lahir':^18}|{'SKS':^6}|")
print(f"+----+{'-'*20}+{'-'*12}+{'-'*18}+{'-'*6}+")
for i in range(len(list_mahasiswa)) :
    print(f"|{str(i):<4}|{list_mahasiswa[i]['nama']:<20}|{list_mahasiswa[i]['nim']:<12}|{str(list_mahasiswa[i]['lahir']):<18}|{list_mahasiswa[i]['sks_lulus']:<6}|")
print(f"+====+{'='*20}+{'='*12}+{'='*18}+{'='*6}+")
input()
