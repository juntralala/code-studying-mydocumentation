import os
import CRUD as CRUD
import time
while True:
    if __name__ == "__main__":
        match os.name:
            case "posix" : os.system("clear")
            case "nt" : os.system("cls")


        print(f"{'selamat datang di program':^40}".upper())
        print(f"database perpustakaan".center(40).upper())
        print(f"<{'='*38}>")

        CRUD.init_console()
        
        print("1. Read data")
        print("2. Add data")
        print("3. Edit data")
        print("4. Delete data\n")

        userOption = input("Masukkan Opsi : ") 

        match userOption:
            case "1" : CRUD.view_console()
            case "2" : CRUD.create_console()
            case "3" : CRUD.update_console()
            case "4" : CRUD.delete_console()
        
        isDone = input("\nApakah selesai[y/n]? ")
        if isDone == "y":
            print("Program berkahir terimakasih kaka😎")
            time.sleep(2.5)
            match os.name:
                case "posix" : os.system("clear")
                case "nt" : os.system("cls")
            break
