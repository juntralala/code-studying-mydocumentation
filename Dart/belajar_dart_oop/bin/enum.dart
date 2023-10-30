/* enum digunakan untuk membuat tipe data yang sudah sudah jelas nilainya 
contohnya : laki dan perempuan
atau level cutomer pada aplikasi kita seperti : premium, reguler, VIP, dll */

enum CustomerLevel { regular, premium, vip}

class Customer {

  String nama ;
  CustomerLevel level;

  Customer(this.nama, this.level);

}

void main(List<String> args){

  var customer1 = Customer('Muhammad Junaidi', CustomerLevel.regular);
  print('Custumer : ${customer1.nama}');
  print('Level    : ${customer1.level}');
  print(CustomerLevel.values);

}