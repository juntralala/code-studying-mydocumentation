import numpy as np
import matplotlib.pyplot as plt
from sklearn import datasets
from sklearn.model_selection import train_test_split
from sklearn.neighbors import KNeighborsClassifier
from sklearn.metrics import classification_report, accuracy_score
import xgboost as xgb
import time

# 1. Load Dataset Gambar Angka (8x8 pixels)
digits = datasets.load_digits()
X = digits.data  # Fitur: 64 kolom (8x8 diratakan)
y = digits.target # Label: angka 0-9

# Split data
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# --- MODEL 1: KNN ---
start_knn = time.time()
knn = KNeighborsClassifier(n_neighbors=5)
knn.fit(X_train, y_train)
knn_preds = knn.predict(X_test)
knn_time = time.time() - start_knn

# --- MODEL 2: XGBoost ---
start_xgb = time.time()
# Kita pakai XGBClassifier agar sintaksnya mirip scikit-learn
model_xgb = xgb.XGBClassifier(
    n_estimators=100,
    max_depth=6,
    learning_rate=0.1,
    objective='multi:softmax',
    use_label_encoder=False,
    eval_metric='mlogloss'
)
model_xgb.fit(X_train, y_train)
xgb_preds = model_xgb.predict(X_test)
xgb_time = time.time() - start_xgb

# 2. Tampilkan Hasil Perbandingan
print(f"{'Model':<15} | {'Akurasi':<10} | {'Waktu Eksekusi':<15}")
print("-" * 45)
print(f"{'KNN':<15} | {accuracy_score(y_test, knn_preds):.4f} | {knn_time:.4f} detik")
print(f"{'XGBoost':<15} | {accuracy_score(y_test, xgb_preds):.4f} | {xgb_time:.4f} detik")