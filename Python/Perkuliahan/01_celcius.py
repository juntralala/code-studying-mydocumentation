from os import system
system("cls")

print(f"<{' Konversi Fahrenheit ke Celcius ':=^60}>")

fahrenheit = float(input('Masukan nilai Fahrenheit : '))
celcius = 5/9 * (fahrenheit - 2)

print(f"Celcius : {celcius:.2f}")