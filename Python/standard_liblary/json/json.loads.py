'''
=> Fungsi json.loads() digunakan untuk mengubah string JSON menjadi objek Python
'''
import json

string_json = '{"name":"ujun", "age": 19, "address":"Tanah Laut"}'
json_obj = json.loads(string_json)

print(json_obj["name"])
print(json_obj["age"])
print(json_obj["address"])

