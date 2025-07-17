# 1. menggabungkan string 
print("Muhammad" " " "Junaidi")
nama_depan = "Muhammad"
nama_belankang = "Junaidi"
print(nama_depan + " " + nama_belankang)

# 2. menghitung panjang string
todo = "Belajar python dasar"
panjang = len(todo)
print(panjang)

# 3. operator string

# mengecek apakah ada kompunen char atau string didalam string
nama_lengkap = "Muhammad Junaidi"
print("Jun" in nama_belankang)
print("B" in nama_belankang)

# mengulang string
print("WK"*6)

# indexing
print("index 0 :", nama_lengkap[0])
print("index 8 :", nama_lengkap[8])
print("index -1 :", nama_lengkap[-1])
print("index 10:7 :", nama_lengkap[9:13])

# ascii code
ascii_code1 = ord("A")
ascii_code2 = ord(" ")
print("ASCII code   A   adalah : ", ascii_code1)
print("ASCII code spasi adalah : " + str(ascii_code2))

# 4. opertor dalam bentuk method
namaku = "Muhammad Junaidi"
jml_a = namaku.count("a")
print(jml_a)
