/*
key pada tipe data map bisa menggunakan tipe data apapun
jika tipeData key dan value pada map tidak di deklarasikan maka dart
akan otomatis menetukan tipeData string jika semua key String
dan jika semua valuenya String maka String jika int maka int
jika key atau value nya berbeda-bada tipe datanya makan tipedatanya akan 
otomatis menjadi Dynamic  
*/



void main() {

  Map<dynamic,String> dataMap = {
    1:'Muhammad Junaidi',
    2:'Ahamad Badawi',
    3:'Abdul Mu\'in',
    'ujun':'Muhmmad Junaidi bin ABD Wahid'
  };

  print(dataMap[1]);
  print(dataMap['ujun']);
  print(dataMap.length);
  print(dataMap.remove(2));
  print(dataMap);
  
  dataMap.clear(); // untuk menghapus selutuh data didalam map 
  print(dataMap); 

}