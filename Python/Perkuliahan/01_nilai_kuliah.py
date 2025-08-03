from os import system
system("cls")

nilai_harian = float(input("Nilai harian\t: "))
nilai_tugas = float(input("Nilai tugas\t: "))
nilai_uts = float(input("Nilai uts\t: "))
nilai_uas = float(input("Nilai uas\t: "))

nilai_akhir = (nilai_harian * 0.1) + (nilai_tugas * 0.2) + (nilai_uts * 0.3) + (nilai_uas * 0.4)

print(f"\nNilai akhir\t: {nilai_akhir:.2f} ")
