class Jumlah:
    
    def __init__(self, nilai1, nilai2):
        self.nilai1 = nilai1
        self.nilai2 = nilai2
        
    def __call__(self) -> int:
        print("kedua buah nilai telah di tambahkan")
        return self.nilai1 + self.nilai2
    
n1 = Jumlah(5,5)

print(n1())