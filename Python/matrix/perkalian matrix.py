# <=============== Perkalian Matrix ===============>
import numpy as np

# menggunakan list
matrix = [[5, 0],
          [1, -2]]

hasil = [[0 for i in range(2)] for i in range(2)]

for row in range(len(matrix)):
  for col in range(len(matrix[row])):
    hasil[row][col] = 2 * matrix[row][col]

print(hasil)

# memnggunakan numpy
    
matrix = np.array([[5, 0],
                   [1, -2]])
hasil = matrix * 2
print(hasil)