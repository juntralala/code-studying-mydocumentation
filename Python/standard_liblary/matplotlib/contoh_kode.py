# kode instalasi : python -m pip install -U matplotlib
# Selanjutnya adalah matplotlibyang merupakan library untuk melakukan visualisasi data.

import matplotlib.pyplot as plt

x = [1, 2, 3, 4, 5]
y = [2, 4, 6, 8, 10]

plt.plot(x, y)

plt.title("Contoh Plot Garis")
plt.xlabel("Sumbu X")
plt.ylabel("Sumbu Y")

plt.show() # menampilkan plot
