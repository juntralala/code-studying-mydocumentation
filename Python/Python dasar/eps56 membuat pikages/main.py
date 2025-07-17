import time 
time_start = time.time()
from os import system as stm
stm('cls')
import my_pikages.matematka
print(f'hasil hitungan my pikages {my_pikages.matematka.tambah(3,6,3,8,6,1,6)}' )

time_end = time.time()
print(f'waktu proses membutuhkan {time_end-time_start}')
input()