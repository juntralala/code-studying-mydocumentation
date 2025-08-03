import time
time_start = time.time()
import os
os.system('cls')

nama2 = ['ipul','udin','amat']
print (f'Data pertama {nama2[0]}')
print(f'Data terakhir {nama2[-1]}')
print(f'Data normal {nama2}')

nama2.insert(1,'amang')
print(f'Data normal {nama2}')

nama2.append('utuh')
print(f'Data normal {nama2}')

genk_kapak = ['ilham','Taichou','Amin','redi']
nama2.extend(genk_kapak)
print(f'Data normal {nama2}')

nama2.remove('ilham')
print(f'Data normal {nama2}')

nama2.pop()
nama2.pop()
nama2.pop()
nama2.pop()
print(f'Data normal {nama2}')

nama2[3] = 'salman'
print(f'Data normal {nama2}')

print(f'{time.time()-time_start:.3} Detik')
input()