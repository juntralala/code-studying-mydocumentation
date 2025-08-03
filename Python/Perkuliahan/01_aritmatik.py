# import os
# os.system("cls")

nilai1 = int(input("Nilai1\t: "))
operator = input("Operator: ")
nilai2 = int(input("Nilai2\t: "))

match operator:
    case "+" : hasil = nilai1 + nilai2
    case "-" : hasil = nilai1 - nilai2
    case "*" : hasil = nilai1 * nilai2
    case "x" : hasil = nilai1 * nilai2
    case "/" : hasil = nilai1 / nilai2
    case ":" : hasil = nilai1 / nilai2
    case salah_semua :
        hasil = 0
        print("INVALID OPERATOR!")

print("Hasil\t: ",hasil)