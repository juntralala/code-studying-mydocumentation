import os
os.system('cls')

teman_teman = {
    'jun' : 'Muhammad Junaidi',
    'pul' : 'Saipul Bahri',
    'wi'  : 'Ahmad Badawi',
    'ham' : 'M Hamdani',
    'mang': 'Muhammad Syarwani'
}

for keys in teman_teman :
    print(teman_teman.get(keys))

for keys in teman_teman.keys() :
    print(keys)

for values in teman_teman.values() :
    print(values)

for keys,values in teman_teman.items() :
    print(f"Keys : {keys} \tValues : {values}")

