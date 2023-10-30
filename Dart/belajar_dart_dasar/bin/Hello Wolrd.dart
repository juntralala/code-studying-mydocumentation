String nama1 = "Muhammad Junaidi";
String nama2 = "Muhammad Rafli Aulia Akbar";
String sapa = "Hallo ";

final nama3 = "ABD Wahid"; // Nilai variable tidak bisa di deklarasikan ulang  

final array1 = [1,2,3,4,5,6];
const array2 = [1,2,3,4,5,6];

void main() {
  print("Hello wolrd");
  print(sapa + nama1);
  print(sapa + nama2);
  print(sapa + nama3);
  print("\n");
  print(array1);
  print(array2);

  array1[1] = 8;  // Variable final valuenya bisa dirubah
  // array2[1] = 8; // Varikable constant tidak bisa di rubah nilai valuenya

  print(array1);
  print(array2);

  print("\n"); // KeyWord late

  late var value = getValue();

  print("Variabble berhasil dibuat");
  print(value);
  
}

String getValue() {
  print("Function dipanggil");
  return "Muhammad Syarwani";
}