import pandas as pd
import os 
from sklearn.preprocessing import StandardScaler
from sklearn.model_selection import train_test_split
from sklearn import linear_model

df = pd.read_csv(os.path.dirname(__file__) + "\\data\\Social_Network_Ads.csv")

# print(df.head())
# print(df.info())

data = df.drop(columns=["User ID"])

data = pd.get_dummies(data, dtype="int")

# print(data.head())


# Pisahkan antara atribute dan lable 
predictions = ['Age', 'EstimatedSalary', 'Gender_Female', 'Gender_Male']
x = data[predictions]
y = data['Purchased']

# Lakukan normalisasi terhadap data yg kita miliki
scaler = StandardScaler()
scaler.fit(x)
scaled_data = scaler.transform(x)
scaled_data = pd.DataFrame(scaled_data, columns=x.columns)
# print(scaled_data.head())


# Bagi data menjadi train dan test untuk setiap data dan lable
x_train, x_test, y_train, y_test = train_test_split(scaled_data, y, test_size=0.2, random_state=1)


# latih model dengan fungsi fit 
model = linear_model.LogisticRegression()
model.fit(x_train, y_train)


# uji akurasi
print("Akurasi :", model.score(x_test, y_test))

# print(x_train.info())