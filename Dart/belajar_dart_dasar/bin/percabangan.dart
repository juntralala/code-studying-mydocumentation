

void main() {
  int nilai1 = 85;
  if (nilai1 >= 80) {
    print('Kamu Lulus dengan nilai yang memuaskan');
  } else if(nilai1>= 70 && nilai1<80) {
    print('kamu aman');
  } else {
    print('Kamu tidak Lulus');
  }

  print('\nini Switch Case\n');

  int nomor = 2;
  switch (nomor) {
    case 1 :print('Kamu memilih nomer 1');break;
    case 2 :print('Kamu memilih nomer 2');break;
    case 3 :print('Kamu memilih nomer 3');break;
    case 4 :print('Kamu memilih nomer 4');break; 
    default : print('Invalid Number');
  }

}