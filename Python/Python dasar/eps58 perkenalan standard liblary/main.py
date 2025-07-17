from os import system
system('cls')

import datetime as dt
tanggal_sekarang = dt.datetime
print(f'{dt.datetime.now().strftime("%A")}')

from collections import Counter
data = ['mhamad junaidi','ahmad maulana','muhammad jamaluddin','muhammad arsyad','abdul muin']
jumlah_data = len(data)
print(jumlah_data)

jumlah_data = Counter(data)
print(jumlah_data)