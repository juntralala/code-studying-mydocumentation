import os
os.system('cls')

class Hero:
    __jumlah = 0
    def __init__(self,nama):
        self.__nama = nama
        Hero.__jumlah += 1

    @staticmethod
    def getJumlah1():
        return Hero.__jumlah

    @classmethod
    def getJumlah(cls):
        return cls.__jumlah
    
    def getjumlah2():
        return Hero.__jumlah

hero1 = Hero("Udin")
hero2 = Hero('Ipul')

print(Hero.getjumlah2())


