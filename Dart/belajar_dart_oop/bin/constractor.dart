class Seseorang {
  String nama = 'kosong';
  int umur = 1;
  String alamat = 'kosong';
  Seseorang({
    String nama ='anonymous',
    int umur =0,
    String alamat = 'unknown'
    }) {
      this.nama = nama;
      this.umur = umur;
      this.alamat = alamat;
  }

}


void main() {

  Seseorang murid1 = Seseorang(
    nama : 'Muhammad Junaidi',
    umur : 18,
    alamat : 'Handil Labuan Amas');

  print('Nama\t: ${murid1.nama}');
  print('Umur\t: ${murid1.umur}');
  print('Alamat\t: ${murid1.alamat}');

}