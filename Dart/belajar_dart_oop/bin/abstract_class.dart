/* Abstract class adalah class yang tidak bisa dibuat objek
   dan hanya bisa diturunkan */

abstract class Lokasi{

  String nama ='';

}

class Kota extends Lokasi {

  Kota(String nama){

    super.nama = nama;

  }

}

void main(List<String> args) {

  // var kota = Lokasi('Jakarta');   <-- abstract class : error
  var kota = Kota('Jakarta'); 

}