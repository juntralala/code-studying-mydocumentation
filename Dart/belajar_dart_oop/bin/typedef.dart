/* typedef berfungsi untuk membuat alias untuk suatu class atu function */

import 'import/sum_callable_class.dart';


// alias untuk class
typedef Jumlah = Sum;
typedef Total = Sum;

// alias untuk function
typedef Filter = String Function(String);

void sayHello(String name, Filter filter){

  print('Hello ${filter(name)}');

}

void main() {

  Total total = Total(1,3);
  Total Jumlah = Total(1,3);

  print(total());
  print(Jumlah());

}