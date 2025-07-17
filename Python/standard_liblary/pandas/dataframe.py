'''
=> (Dicoding) DataFrame merupakan struktur dua dimensi yang menyimpan data dalam bentuk baris dan kolom
=> (CHAT-GPT3.5) DataFrame adalah struktur data dua dimensi yang sangat serbaguna dan kuat yang terdapat
   dalam pustaka pandas untuk pemrograman Python. DataFrame pada pandas dapat dianggap sebagai tabel atau
   struktur data berupa baris dan kolom, mirip dengan spreadsheet atau tabel SQL. Ini memberikan cara yang
   efisien dan mudah untuk menyimpan, mengelola, dan menganalisis data tabular.\
=> fitur-fitur pandas :
   -> Struktur Tabular         : DataFrame menyusun data dalam bentuk tabel dengan baris dan kolom. Setiap
                                 kolom dapat memiliki tipe data yang berbeda, seperti integer, float, string,
                                 atau datetime.
   -> Label Baris dan Kolom    : DataFrame memiliki label untuk baris (indeks) dan kolom, yang memudahkan
                                 dalam referensi dan manipulasi data.
   -> Manipulasi Data          : Anda dapat melakukan berbagai operasi manipulasi data seperti pengindeksan,
                                 penggabungan, pengelompokan, filter, dan transformasi data dengan mudah
                                 menggunakan DataFrame.
   -> Penanganan Missing Values: DataFrame menyediakan metode untuk menangani nilai-nilai yang hilang atau 
                                 NaN dalam data.
   -> IO (Input/Output)        : Pandas mendukung berbagai format file (CSV, Excel, SQL, dll.) untuk masukan
                                 dan keluaran data.
'''

import pandas as pd

data = {
    "nama":["ujun", "Humaidi", "Wahid"],
    "usia":[19, 26, 25],
    "kota":["Tanah Laut", "Tanah Laut", "Tanah Laut"]
}

df = pd.DataFrame(data)
print(df)
