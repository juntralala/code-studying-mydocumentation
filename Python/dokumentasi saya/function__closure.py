import os
os.system("cls")

def makeAdder(a):
    owner = "UJUN"
    def add(angka): 
        print(owner)
        hasil = a + angka
        return hasil
    return add

addTwo = makeAdder(2)

print(addTwo(4))