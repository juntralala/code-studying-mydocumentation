
angka = int(input("Angka : "))

match angka :
    case 1 : print("angka = 1")
    case bind if bind >0 : print("angka = positif")
    case bind if bind <0 : print("angka = negatif")
    case _ : print("Bukan angka")