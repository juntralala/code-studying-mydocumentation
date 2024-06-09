import pickle

pickle_masuk = open("dict.pickle", "rb")
contohDictionary = pickle.load(pickle_masuk)
pickle_masuk.close()
 
print(contohDictionary)