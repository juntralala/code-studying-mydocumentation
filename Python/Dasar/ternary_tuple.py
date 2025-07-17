lulus = True
pesan = ("value salah", "value true")[lulus]
print(pesan)

"""
=> Perlu diingat oleh Anda, ternary tuples sebaiknya dihindari terutama untuk kode dan klausa true/false
   yang kompleks. Komunitas Python sendiri menganggap bahwa cara ternary tuples ini kurang "pythonic" atau
   "tidak Python banget!" karena cukup membingungkan untuk meletakkan kondisi saat True atau False.
"""