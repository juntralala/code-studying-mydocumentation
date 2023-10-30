class Seseorang{

  String nama = '';
  String namaDepan = '';
  String namaBelakang = '';

  Seseorang(this.nama) :
    namaDepan = nama.split(' ')[0],
    namaBelakang = nama.split(' ')[1] {

  }

  void sapaDiriSendiri(){
    print('Selamat Pagi $nama');
  }

}



void main() {

  Seseorang saya = Seseorang('Muhammad Junaidi');

  print(saya.nama);
  print(saya.namaDepan);
  print(saya.namaBelakang);

  saya.sapaDiriSendiri();


}