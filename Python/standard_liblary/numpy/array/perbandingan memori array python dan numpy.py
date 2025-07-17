# Perbandingan penggunaan memori array di python dan numpy
import numpy
import sys

arr_list = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
arr_numpy = numpy.array([[1, 2, 3], [4, 5, 6], [7, 8, 9]])

print(f"""
array List size  : {sys.getsizeof(arr_list) * len(arr_list)} bytes
array numpy size : {arr_numpy.size * arr_numpy.itemsize} bytes
""")

'''
numpy menyediakan tipe data array yang lebih efisien memori
dibanding tipe data list bawaan python
'''