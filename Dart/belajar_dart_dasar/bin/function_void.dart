void main() {
  sapa('Muhammad Barizi');
  sapa('UJUN');
  sapa('Muhammad Rafli Aulia Akbar');

  print(' ');

  sapa2('Muhammad','Junaidi');
  sapa2('Humaidi');

  print(' ');

  sapa3('Muhammad','Abu','Yazid');
  sapa3('Muhammad','Junaidi');
  sapa3('Ujun');

  print(' ');

  sapa4(lastName: 'Badawi',firstName: 'Ahmad');
  sapa4(firstName: 'Humaidi');
  sapa4();
//sapa4('Muhammad','Junaidi');   => function dengan named parameter akan error

  print('<===========Required parameter==========>');

  sapa5(firstName: 'Muhammad', lastName: 'Junaidi');
  sapa5(firstName: 'Humaidi');
}

void sapa(String nama) {
  print('Hai kamu, $nama');
}

// parameter optional
void sapa2(String firstName,[String? lastName]) {
  print('apa kabar $firstName $lastName');
}

// optional parameter dengan default value
void sapa3(String firstName,[String middleName='', String lastName='']) {
  print('hallo $firstName $middleName $lastName');
}

// named parameter 
// <[parameternya harus nullable atau punya default value]>
void sapa4({String? firstName,String lastName=''}) {
  print('Hai $firstName $lastName');
}

// named parameter dengan optional parameter tidak bisa di gabungkan

// named operator bisa menggunakan required supaya parameternya menjadi wajib di masukkan
// required parameter tidak wajib lagi menggunakan value default atau nullable
void sapa5({required String firstName, String lastName = ''}) {
  print('Hai $firstName $lastName');
}


