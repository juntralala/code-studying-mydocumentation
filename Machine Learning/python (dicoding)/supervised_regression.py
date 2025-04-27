import numpy as np
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression


# Buat data jumlah kamar dalam sebua rumah
bedrooms = np.array([1,1,2,2,3,4,4,5,5,5])

# data harga rumah asumsikam dalam jumlah dolar
house_price = np.array([15_000, 18_000, 27_000, 34_000,50_000, 68_000, 65_000, 81_000, 85_000, 90_000])

# menampilkan data
plt.scatter(bedrooms, house_price)

plt.title("harga rumah")
plt.xlabel("Jumlah kamar")
plt.ylabel("Harga kamar")

# plt.show()


# melatih model
bedrooms = bedrooms.reshape(-1, 1)
linreg = LinearRegression()
linreg.fit(bedrooms, house_price)


# menampilkan plot hubungan antara jumlah kamar dengan harga rumah
plt.scatter(bedrooms, house_price)
plt.plot(bedrooms, linreg.predict(bedrooms))

plt.show()
