import os
os.system("CLS")

print("Program Konversi Suhu")
print("*"*25)

celcius = float(input("Masukan besaran derajat suhu Celcius : "))
fahrenheit = (celcius * 1.8) + 32
reamur = (4/5)*celcius

print("Hasil konversi ke fharenheit =", fahrenheit)
print("Hasil konversi ke reamur     = %.2f"%reamur)
