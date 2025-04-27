from os import path
import pandas as pd
from sklearn.model_selection import train_test_split

df = pd.read_csv(path.dirname(__file__) + "/data/diabetes.csv")

# print(df.head())

# memisahkan atribut pada dataset dan menyimpannya pada sebuah variabel
x = df[df.columns[:8]]
# print(x)

# memisahkan atribut pada dataset dan menyimpannya pada sebuah variabel
y = df['Outcome']

# melalkukan standarisasi pada data
from sklearn.preprocessing import StandardScaler

# standarisasi nilai-nilai dari dataset 
scaler = StandardScaler()
scaler.fit(x)
x = scaler.transform(x)

x_train, x_test, y_train, y_test = train_test_split(x, y, test_size=0.25, random_state=42)


# Kita kemudian membuat objek Support Vector Classifier
from sklearn.svm import SVC

# membuat object SVC dan memanggil fungsi fit untuk melatih model 
clf = SVC()
clf.fit(x_train, y_train)

print(clf.score(x_test, y_test))

