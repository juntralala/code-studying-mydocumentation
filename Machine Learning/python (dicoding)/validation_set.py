import sklearn 
from sklearn import datasets
from sklearn import tree
from sklearn.model_selection import cross_val_score



iris = datasets.load_iris()
data = iris.data
target = iris.target

clf = tree.DecisionTreeClassifier()

scores = cross_val_score(clf, data, target, cv=5)

print(scores)