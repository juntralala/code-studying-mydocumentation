# <========== Operasi Tranpose Matrix ==========>
import numpy as np

matrix = [[5, 0],
          [1, -2]]
tranposed = [[0 for i in range(2)] for i in range(2)]
for row in range(len(matrix)):
    for col in range(len(matrix[row])):
        tranposed[col][row] = matrix[row][col]
print(tranposed)

# pakai numpy
matrix = np.array([[5, 0],
                   [1, -2]])
tranposed = matrix.T
print(tranposed)