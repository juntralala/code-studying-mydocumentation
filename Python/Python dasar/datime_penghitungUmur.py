import os
os.system('CLS')
import datetime as dt

hari_ini = dt.date.today()
print("Tanggal hari ini : ",hari_ini,"\nInput Tanggal lahir anda ")

tanggal = int(input("tanggal :"))
bulan = int(input("Bulan : "))
tahun = int(input("Tahun : "))

tanggal_lahir = dt.date(tahun,bulan,tanggal)
print(f"Tanggal lahir : {tanggal_lahir}")
umur = hari_ini - tanggal_lahir
umur_tahun = umur.days//365.25
umur_bulan = (umur.days-365*umur_tahun)//30
umur_hari = (umur.days-365*umur_tahun)%30

print(f'Hari lahir : {tanggal_lahir:%A}\nUmur tahun : {int(umur_tahun)}\nUmur bulan : {int(umur_bulan)}\nUmur hari : {int(umur_hari)}')

