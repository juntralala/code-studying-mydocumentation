import os
os.system('cls')

def nama(**kwargs):
    for nama,tugas in kwargs.items():
        print(f"{nama.upper()} bertugas sebagai {tugas}")

nama(udin ='Penyairan',ilham ='Master Chief',ipul ='Comandor',amin ='Penarbangan')