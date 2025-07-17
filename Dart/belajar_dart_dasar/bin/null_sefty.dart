void main() {

  int? nullAble = null;
  nullAble = 1;
 
  if (nullAble != null){
    double? dataDouble = nullAble.toDouble();
    print(dataDouble);
  }

  // Konvertion NonNullAble dan nullAble
  // nonNullAble ke nullAble
  String name = 'UJUN';
  String? nullAbleName = name;
  
  int? nullAblePrice;
  // nullAblePrice = 8;
  if (nullAblePrice != null) {       /* Konversi nullAble ke nonNullAble wajib pakai nullCheck */
    int price = nullAblePrice;
  }


  String? nullableNama;
  // nullableNama = 'Ujun 1';
  
  String nama = nullableNama ?? 'dawi';
  print(nama);

  // melakukan paksa konversi

  // int? nullAbleAngka3;
  // nullAbleAngka3 = 1;
  // int Angka3 = nullAbleAngka3!; // jika nullAbleAngka3 = null maka akan terjadi error


  // mengakses data null

  int? dataInt;

  // dataInt = 4;

  double? dataDouble2 = dataInt?.toDouble(); 
  print(dataDouble2);







}