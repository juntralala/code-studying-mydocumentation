from .operasi import create,input_data_data,read,view_data,update,delete

def view_console():
    view_data()

def create_console():
    print(f"\n\n<{' Masukkan Data ':=^38}>")
    inputs = input_data_data()
    create(inputs[0],inputs[1],inputs[2]) # penulis = inputs[0], judul = inputs[1], tahun = inputs[2]
    view_data()

def update_console():
    print("\n<<"+" Silahkan nomor buku dibawah untuk dirubah ".center(38,"=")+">>")
    view_console()

    while True:
        try:
            nomor_buku = int(input("Pilih Nomer buku : "))
            data_buku = read(index=nomor_buku)
            if data_buku:
                break
            else:
                print("Nomor tidak valid, silahkan masukkan lagi")

        except:
            print("Input tidak valid, silahkan masukkan lagi")
    
    data_buku_break = data_buku.split(",")
    pk = data_buku_break[0]
    tanggal_ditambahkan = data_buku_break[1]
    penulis = data_buku_break[2]
    judul = data_buku_break[3]
    tahun = data_buku_break[4][0:4]

    while True:
        print("\n\n" + f"<<{'silahkan pilih data yang mau dirubah':=^46}>>")
        print("1. Penulis\t: " + penulis[:40])
        print("2. Judul\t: " + judul[:40])
        print("3. Tahun\t: " , tahun)

        user_option = input("Pilih data [1/2/3]: ")

        print(f"\n<<{' Rubah data buku ':=^46}>>")

        match  user_option:
            case "1" : penulis = input("Penulis menjadi : ")
            case "2" : judul = input("Judul menjadi : ")
            case "3" : 
                while True:
                    try:
                        tahun = int(input("Tahun menjadi\t: ")) 
                        if (len(str(tahun))==4):
                            break

                        else:
                            print("tahun tidak boleh dari 4 angka[yyyy]")
                    except:
                        print("Tahun harus angka")
                        print("Masukin datanya yang bener dong boss, aku pusying!!😓")
            case _ : print(f"Input invalid, {user_option} tidak terdapat dalam opsi")
        selesai = input("\nSudah selesai[y/n]? ")
        if selesai=="y":
            break
        
    update(pk,tanggal_ditambahkan,nomor_buku,penulis,judul,tahun)
    view_console()

def delete_console():
    datas_buku = read()
    jumlah_buku = len(datas_buku)
    print(f"\n\n<{' Pilih No Buku yang Akan Dihapus ':=^46}>")
    view_console()
    while True:
        while True:
            try:
                no_buku = int(input("Pilih nomor buku yang akan dihapus : "))
                if ((no_buku > 0) and (no_buku <= jumlah_buku)):
                    break
                else:
                    print("Tidak ada buku yang sesuai dengan input, Silahkan pilih lagi")
            except:
                print("Input harus berupa Angka")

        data_buku = datas_buku[no_buku-1]
        data_buku_break = data_buku.split(",")
        pk = data_buku_break[0]
        tanggal_ditambahkan = data_buku_break[1]
        penulis = data_buku_break[2]
        judul = data_buku_break[3]
        tahun = data_buku_break[4]

        print("\n\n" + f"<<{' Data yang Ingin Anda Hapus ':=^46}>>")
        print("1. Penulis\t: " + penulis[:40])
        print("2. Judul\t: " + judul[:40])
        print("3. Tahun\t: " , tahun)

        yakin = input("Anda yakin[y/n]? ")
        if yakin == "y":
            delete(no_buku)
            break
        
    

