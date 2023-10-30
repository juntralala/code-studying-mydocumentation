import 'dart:io';

void main() {
  int ukuranSegitiga;

  while (true) {
    stdout.write('Masukkan ukuran segitiga : ');
    String? inputUser = stdin.readLineSync(retainNewlines: false);
    if (inputUser != null) {
      try {
      ukuranSegitiga = int.parse(inputUser.toString());
      break;
      } catch (e) {
        print('Input error, meminta input user sekali lagi\n');
        continue;
      } 
    }
    print('Input tidak boleh null, meminta input diulangi\n');
  }

  for (int index=0 ; index<2 ; index++)  {
    int spasi;
    for (int i=1 ; i<=ukuranSegitiga ; i++) {
      if (index == 0) {
        spasi = ukuranSegitiga-i;
        print('${"  "*spasi}${(" *"*i)*2}');
      } else {
        spasi = i-1;
        print('${"  "*spasi}${(" *"*(ukuranSegitiga-spasi))*2}');
      }
    }
  }

}