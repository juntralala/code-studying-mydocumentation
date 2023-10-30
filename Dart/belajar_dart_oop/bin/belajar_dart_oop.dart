import 'dart:io';

class seseorang {
  String nama = "Kosong";
  String? alamat;
  final String jenis = "Manusia";  
}

void main(List<String> arguments) {

  var saya = seseorang();

  print('Hello world: ${saya.nama}!');
  saya.nama = "Muhammad Junaidi";
  print(saya.nama);
  print('Alamat : ${saya.alamat}');
  saya.alamat = "HLA";
  print('Alamat : ${saya.alamat}');
  print('Kelamin : ${saya.jenis}');



  stdin.readLineSync();
}
