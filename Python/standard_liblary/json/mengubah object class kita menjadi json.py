"""
=> JSON secara default hanya dapat merepresentasikan subset dari built-in type pada Python. Jadi tidak bisa
   mengkonversi object dari class buatan kita
=> Agar sebuah object dari class yang kita buat bisa dikonversi menjadi json, kita mengkonversi object kita
   menjadi dictionary mengunakan property __dict__
=> property __dict__ sebernarnya sudah bawaan class Object, jadi kita tidak perlu membuatnya secara manual
"""

import json


class Person:

    def __init__(self, name, age, address):
        self.name = name
        self.age = age
        self.address = address


ujun = Person("ujun", 19, "Tanah Laut")
ujun_dict = ujun.__dict__

json_string = json.dumps(ujun_dict, indent=2)
print(json_string)
