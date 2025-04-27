'''
Library sklearn menyediakan dataset iris yakni sebuah dataset yang umum digunakan untuk masalah klasifikasi.
Dataset ini memiliki jumlah 150 sampel
'''

import sklearn
from sklearn.datasets import load_iris
from sklearn.model_selection import train_test_split

iris = load_iris()

data = iris.data
target = iris.target

data_train, data_test, target_train, target_test = train_test_split(data, target, test_size=0.2, random_state=1)

print(f"{data_test} | {target_test}")

print(f"Total Panjang data : {len(data)}")
print(f"Jumlah data Test   : {len(data_test)}")