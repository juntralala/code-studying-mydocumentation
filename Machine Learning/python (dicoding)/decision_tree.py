import pandas as pd 
import os
from sklearn.model_selection import train_test_split
from sklearn.tree import DecisionTreeClassifier
from sklearn.metrics import accuracy_score

iris = pd.read_csv(os.path.dirname(__file__) + "\\data\\Iris.csv")

print(iris.info())

print(iris.head())

iris.drop('Id', axis=1, inplace=True)

data = iris[['SepalLengthCm', 'SepalWidthCm', 'PetalLengthCm', 'PetalWidthCm' ]]
target = iris['Species']

data_train, data_test, target_train, target_test = train_test_split(data, target, train_size=0.2)

tree_model = DecisionTreeClassifier()

tree_model = tree_model.fit(data_train, target_train)

target_prediction = tree_model.predict(data_test)

accu_score = round(accuracy_score(target_prediction, target_test), 3)

print("Accuracy :", accu_score)

print(tree_model.predict([[6.2, 3.4, 5.4, 2.3]])[0])

# =================================================

from sklearn.tree import export_graphviz
export_graphviz(
    tree_model,
    out_file = "iris_tree.dot",
    feature_names = ['SepalLengthCm', 'SepalWidthCm', 'PetalLengthCm', 'PetalWidthCm'],
    class_names = ['Iris-setosa', 'Iris-versicolor', 'Iris-virginica' ],
    rounded= True,
    filled =True)