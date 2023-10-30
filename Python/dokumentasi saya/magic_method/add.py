class Kotak:
    
    def __init__(self,panjang:int,tinggi:int):
        self.panjang:int = panjang
        self.tinggi:int = tinggi
        self.luas:int = panjang * tinggi
    
    def __add__(self,other):
        return Kotak(self.panjang + other.panjang , self.tinggi + other.tinggi)
    
    def __repr__(self):
        return f"tinggi : {self.panjang} panjang : {self.tinggi} luas : {self.luas}"

kotak1 = Kotak(12,10)
kotak2 = Kotak(6,15)

kotak3 = kotak1 + kotak2

print(kotak1)
print(kotak2)
print(kotak3)
        