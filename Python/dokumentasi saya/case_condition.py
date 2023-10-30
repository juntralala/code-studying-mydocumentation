
angka = int(input("Angka : "))
angka2 = int(input("Angka2 : "))

match angka :
    case 1 : print("angka = 1")
    case 2 if angka2 >0 : print("angka = 2 \nangka2 = positif")
    case 2 if angka2 <0 : print("angka = 2 \nangka2 = positif")
    case _ : print("angka != 1 atau 2")