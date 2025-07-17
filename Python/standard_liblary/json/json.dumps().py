'''
=> json.dumps() digunakan untuk mengkonversi object python menjadi string dengan struktur json
'''

import json 

orang = {"name":"Junaidi", "age": 19, "address": "Tanah Laut"}

json_string = json.dumps(orang, indent=4)
print(type(json_string))
print(json_string)