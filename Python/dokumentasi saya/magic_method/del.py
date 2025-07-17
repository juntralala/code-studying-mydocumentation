class Contoh:
    
    def __init__(self,nama):
        self.nama =  nama
        
    def __str__(self):
        return 'ini objek {:s}'.format(self.nama)
    
    # def __repr__(self) -> str:
    #     pass
        
    def __del__(self):                       # <-- auto delete
        print("objek ini telah di hapus")
        

objek1 = Contoh('Junaid')

print(objek1)

print(objek1)