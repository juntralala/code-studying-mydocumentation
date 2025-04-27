from os.path import dirname
import pandas as pd

dt = pd.read_csv(dirname(__file__) + "/data/Salary_Data.csv")
dt.info()

# Kemudian pisahkan atribut dan label pada dataset
import numpy as np

x = dt['YearsExperience']
y = dt['Salary']

# mengubah bentuk atribute
x = np.array(x)
x = x.reshape(-1 ,1)

"""
Selanjutnya, untuk menggunakan grid search, kita impor library GridSearchCV dari sklearn.model_selection. Lalu,
 kita buat model yang ingin kita uji dengan grid search dalam hal ini model SVR. Kemudian kita buat sebuah python
 dictionary yang berisi nama parameter yang akan diuji, serta nilai-nilainya. Selanjutnya kita buat objek grid
 search dan mengisi parameter-parameternya. Parameter pertama adalah model yang akan kita uji. Parameter kedua
 adalah dictionary yang berisi kumpulan parameter dari model yang akan diuji. Terakhir kita panggil fungsi fit()
 pada objek grid search yang telah kita buat.
"""
from sklearn.model_selection import GridSearchCV
from sklearn.svm import SVR

# membangun model dengan parameter C, gamma dan kernel
model = SVR()
parameters = {
    'kernel': ['rbf'],
    'C': [1_000, 10_000, 100_000],
    'gamma': [0.5, 0.05, 0.005] 
}

grid_search = GridSearchCV(model, parameters)

# melatih model dengan fugsi fit
grid_search.fit(x, y)

'''
Setelah grid search mencari parameter terbaik pada model, kita bisa menampilkan parameter terbaik dengan
 memanggil atribut best_params_ dari objek grid search.
'''
# Menampilkan parameter terbaik dari object grid_search
print(grid_search.best_params_)



# Selanjutnya, membuat model SVM baru dengan parameter terbaik hasil grid search 
model_baru = SVR(C=100_000, gamma=0.005, kernel='rbf')
model_baru.fit(x, y)


# Terakhir kita bisa memvisualisasikan SVR dengan parameter hasil grid search.
import matplotlib.pyplot as plt

plt.scatter(x, y)
plt.plot(x, model_baru.predict(x))
plt.show()

