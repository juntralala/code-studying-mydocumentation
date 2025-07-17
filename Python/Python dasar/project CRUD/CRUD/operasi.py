from . import dataBase
from .util import randomString
import time
import os

def view_data():
    data_file = read()
    no = "No"
    penulis = "Nama Penulis"
    judul = "Judul"
    tahun = "Tahun"
    print("+" + "="*4 + "+" + "="*30 + "+" + "="*30 + "+" + "="*6 + "+")
    print(f"|{no:^4}|{penulis:^30}|{judul:^30}|{tahun:^6}|")
    print("+" + "="*4 + "+" + "="*30 + "+" + "="*30 + "+" + "="*6 + "+")

    no = 0
    for data in data_file:
        data_break = data.split(",")
        no += 1
        pk = data_break[0]
        add_data = data_break[1]
        penulis = data_break[2]
        judul = data_break[3]
        tahun = data_break[4]
        print(f"|{no:^4}|{penulis[:30]:^30}|{judul[:30]:^30}|{tahun[0:4]:^6}|")
    print("+" + "="*4 + "+" + "="*30 + "+" + "="*30 + "+" + "="*6 + "+")

def operasi_data(pk,tanggal_ditambahkan,penulis,judul,tahun,no_buku=0,mode:str="r"):

    data = dataBase.template.copy()

    data["pk"] = randomString(6) if pk==None else pk
    data["tanggal_ditambahkan"] = time.strftime("%Y-%m-%d-%H-%M-%S-%z",time.gmtime()) if tanggal_ditambahkan == None else tanggal_ditambahkan
    data["penulis"] = penulis + dataBase.template['penulis'][len(penulis):]
    data["judul"] = judul + dataBase.template['judul'][len(judul):]
    data["tahun"] = str(tahun) 

    data_string = f'{data["pk"]},{data["tanggal_ditambahkan"]},{data["penulis"]},{data["judul"]},{data["tahun"]}\n'

    try:
        with open(dataBase.dataBaseName,mode,encoding="utf-8") as file:
            match mode:
                case "r":
                    content = file.readlines()
                    return content
                case "w" :
                    file.write(data_string)
                case "a" :
                    file.write(data_string)
                case "r+":
                    panjang_data = len(data_string)
                    file.seek(panjang_data*(no_buku-1))
                    file.write(data_string)
    except:
        print("Gagal melakukan operasi pada data")

def input_data_data():
    penulis = input("Penulis : ")
    judul   = input("Judul   : ")
    while True:
        try:
            tahun = int(input("Tahun\t: ")) 
            if (len(str(tahun))==4):
                break

            else:
                print("tahun tidak boleh dari 4 angka[yyyy]")
        except:
            print("Tahun harus angka")
            print("Masukin datanya yang bener dong boss, aku pusying!!😓")

    return [penulis,judul,tahun]
 
def create_first_data():
    inputs = input_data_data()
    penulis = inputs[0]
    judul = inputs[1]
    tahun = inputs[2]
    operasi_data(None,None,penulis,judul,tahun,mode="w")

def read(**kwargs):
    try:
        with open(dataBase.dataBaseName,"r") as file:
            content = file.readlines()
            if not "index" in kwargs:
                return content
            else:
                if kwargs["index"]-1 < 0 or kwargs["index"] > len(content):
                    return False
                else:
                    return content[kwargs["index"]-1]
    except:
        print("Membaca Data Base Error!😫😓")
        return False

def create(penulis,judul,tahun):
    operasi_data(None,None,penulis,judul,tahun,mode="a")
    
def update(pk,data_ditambahkan,no_buku,penulis,judul,tahun):
    operasi_data(pk,data_ditambahkan,penulis,judul,tahun,no_buku,mode="r+")

def delete(nomor_buku):
    try:
        counter = 1
        while True:
            buku = read(index=counter)
            if buku == False:
                break
            elif counter == nomor_buku:
                pass
            else:
                with open("data_temp.txt","a",encoding="utf-8") as file:
                    file.write(buku)
            counter += 1
    except:
        print("DataBase Error!")

    os.remove(dataBase.dataBaseName)
    os.rename("data_temp.txt",dataBase.dataBaseName)





    



