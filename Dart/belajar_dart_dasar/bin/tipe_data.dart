import 'dart:typed_data';

void main () {
  // tipe data number ada 2
  int number1 = 10;
  double number2 = 10.1;

  // boolean
  bool boolean1 = true;
  bool boolean2 = false;

  // String                                               // String di Dart bisa menggunakan '' atau "" tetapi lebih direkomendasikan menggunakan '' 
  String firstName = "Muhammad";
  String lastName = 'Junaidi'; 
    // Expresion didalam String                           // string bisa menggunakan expresion menggunakan ${namaVarible} atau $namaVariable
  String fullName1 = "${firstName} $lastName"; 
    // penggabungan String                                // operasi Menggabungkakn string bisa menggunakan + atau karater whitespace yaitu spasi, tap, dan enter
  String fullName2 = firstName + lastName;
  String fullName3 = 'Muhammad' ' ' 'Junaidi';    // whitespace hanya bisa digunakan untuk String Literal
    // string multiline
  String longString1 = '''
Ini adalah String multiline
multiline String
pada Dart
''';
  String longString2 = """
Ini adalah String multiline
multiline String
pada Dart
""";

  // Dynemic
  dynamic variable1 = 100;
  variable1 = 3.14;
  variable1 = 'Muhammad Junaidi';
  variable1 = true;

  // nullAble
  int? number3;
  int number4;
  dynamic number6;
  var number5;

  print(number3);
  // print(number4); ini akan error karena nullable
  print(number5);
  print(number6);

} 