from sklearn import datasets
from sklearn.model_selection import train_test_split

iris = datasets.load_iris()
atribute = iris.data
label = iris.target

# bagi data set menjadi train set dan test set
x_train, x_test, y_train, y_test = train_test_split(atribute, label, test_size=0.2, random_state=1)

# Kita akan menggunakan model Decision Tree dan menghitung berapa akurasinya tanpa menggunakan PCA
from sklearn import tree

decision_tree = tree.DecisionTreeClassifier()
model_pertama = decision_tree.fit(x_train, y_train) 
print(model_pertama.score(x_test, y_test))

# Kemudian kita akan menggunakan PCA dan menghitung variance dari setiap atribut
from sklearn.decomposition import PCA 

# membuat PCA dengan 4 principal compunent
pca = PCA(n_components=4)

# Mengaplikasikan PCA pada dataset
pca_attribute = pca.fit_transform(x_train)

# meliat variance dari setiap attribute
print(pca.explained_variance_ratio_)

# PCA dengan 2 principal component
pca = PCA(n_components = 2)
x_train_pca = pca.fit_transform(x_train)
x_test_pca = pca.fit_transform(x_test)

# uji akurasi classifier
model2 = decision_tree.fit(x_train_pca, y_train)
print(model2.score(x_test_pca, y_test))

