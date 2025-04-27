import pandas as pd
from os.path import dirname

df = pd.read_csv(dirname(__file__) + "/data/Salary_Data.csv")

# df.info()

'''
Kemudian kita pisahkan antara atribut dan label yang ingin diprediksi. Ketika hanya terdapat satu atribut pada
 dataframe, maka atribut tersebut perlu diubah bentuknya agar bisa diterima oleh model dari library SKLearn.
 Untuk mengubah bentuk atribut kita membutuhkan library numpy.
'''
import numpy as np

# memisahkan atribute dan lable
x = df['YearsExperience']
y = df['Salary']

# mengubah bentuk atribut
x = np.array(x)
x = x[:,np.newaxis]

'''
Berikutnya kita buat objek support vector regression dan di sini kita akan mencoba menggunakan parameter
 C = 1000, gamma = 0.05, dan kernel ‘rbf’. Setelah model dibuat kita akan melatih model dengan fungsi fit
 pada data.
'''
from sklearn.svm import SVR

# membangun model dengan parameter C, gamma, dan kernel 
model = SVR(C=1000, gamma=0.05, kernel='rbf')

# melatih model dengan fungsi fit
model.fit(x, y)

'''
Terakhir kita bisa memvisualisasikan bagaimana model SVR kita menyesuaikan terhadap pola yang terdapat pada 
 data menggunakan library matplotlib.
'''
import matplotlib.pyplot as plt

# mevisualisasikan model
plt.scatter(x, y)
plt.plot(x, model.predict(x))
plt.show()