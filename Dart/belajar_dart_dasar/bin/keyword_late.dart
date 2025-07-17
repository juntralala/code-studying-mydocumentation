void main() {
    
    int hasilTambah1 = tambah(5, 5);
    print("pemisah");
    print(hasilTambah1);

    print("\n");

    late int hasilTambah2 = tambah(5, 5);
    print("pemisah");
    print(hasilTambah2);

}


int tambah(int a,int b) {
    int hasil = a +b;
    print("angka telah ditambahkan");
    return hasil;
}