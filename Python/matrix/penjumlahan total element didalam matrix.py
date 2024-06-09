# <================ penjumlahan total element didalam matrix ================>
import numpy as np

# dengan list
matrix = [[5, 0],
          [1, -2]]
total = 0
for row in range(len(matrix)):
    for col in range(len(matrix[row])):
        total += matrix[row][col]
print(f"pakai list : {total}")

# dengan numpy
matrix = np.array([[5, 0],
                  [1, -2]])
total = np.sum(matrix)
print(f"pakai numpy: {total}")
