def deret( angkaAwal, selisih, n):
    if n == 1:
        return angkaAwal
    print(n)
    return selisih + deret(angkaAwal, selisih, n - 1 )

print(deret(5, 3, 11))