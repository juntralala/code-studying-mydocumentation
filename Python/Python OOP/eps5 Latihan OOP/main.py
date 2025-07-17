import os
os.system('cls')

class Hero:
    jumlah = 0

    def __init__(self,name,health,deffend,attack):
        self.__name = name
        self.__health = health
        self.__deffend = deffend
        self.__attack = attack

    def menyerang(self,heroDiserang):
        print(f'{self.__name} menyerang si {heroDiserang.__name}')
        heroDiserang.diserang(self.__attack)
        if heroDiserang.__health<=0:
            print(f"{heroDiserang.__name} telah KO")
        else :
            print(f'Darah {heroDiserang.__name} berkurang menjadi : {heroDiserang.__health}')


    def diserang(self,attackPenyerang):
        damageDiTerima = attackPenyerang-self.__deffend
        self.__health -= damageDiTerima
        print(f"kerusakan diterima {self.__name} : {damageDiTerima}")

hero1 = Hero('Udin',100,30,25)
hero2 = Hero('ipul',100,5,50)

hero1.menyerang(hero2)
hero1.menyerang(hero2)
hero1.menyerang(hero2)
hero2.menyerang(hero1)
hero2.menyerang(hero1)
hero2.menyerang(hero1)
hero2.menyerang(hero1)
hero2.menyerang(hero1)

hero1.menyerang(hero2)
hero1.menyerang(hero2)

