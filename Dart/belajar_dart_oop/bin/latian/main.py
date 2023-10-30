import os
os.system('cls')

def filterBadWord(word:str):
    if 'anjing' in word or 'goblok' in word or 'bangsad' in word or 'kontol' in word:
        return '*'*word.__len__()
    else:
        return word

def sayHello(nama:str,filter:'function'):
    print(f"hallo {filter(nama)}")

sayHello('Muhammad Junaidi',filterBadWord)


sayHello('anjing',filterBadWord)
sayHello('kontol',filterBadWord)
sayHello('bangsad',filterBadWord)
sayHello('goblok',filterBadWord)
sayHello('bacot kau goblok',filterBadWord)

print('{0:0x}'.format(id(filterBadWord)))