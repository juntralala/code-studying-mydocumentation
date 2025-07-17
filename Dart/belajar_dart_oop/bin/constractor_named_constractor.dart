class Seseorang{

  String nama = "";
  int umur = 0;
  String alamat = "";

  Seseorang(this.nama, this.umur, this.alamat){}

  Seseorang.hanyaNama(this.nama){}

  Seseorang.hanyaUmur(this.umur){}

  Seseorang.hanyaAlamat(this.alamat){} 

}

void main() {

  Seseorang temen = Seseorang.hanyaNama('Ahmad Badawi');

  print(temen.nama);
  print(temen.umur);
  print(temen.alamat);

}