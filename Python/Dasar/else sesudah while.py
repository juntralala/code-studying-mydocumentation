'''Else setelah While
=> Berbeda dengan else setelah for, pada statement else setelah while, blok statement else akan selalu
   dieksekusi saat kondisi pada while menjadi salah. 
''' # tanpa beak
count = 0

while count < 3:
    print("Dicoding Indonesia")
    count += 1
else:
    print("Blok else dieksekusi karena kondisi pada while salah (3<3 == False).")
    
# dengan break
n = 10
while n > 0:
    n = n - 1
    if n == 7:
        break
    print(n)
else:
    print("Loop selesai")
    

