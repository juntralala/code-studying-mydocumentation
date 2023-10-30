/* variable menggunakan underscore(_) tidak bisa diaccess di file yang lain*/

import 'import/product_untuk_access_modifier.dart';

void main(List<String> args) {

  var product = Product()
  ..id = '0001'
  ..nama = 'Laptop';
  // .._quantity = 2; <-- ini tidak bisa di lakukan karna pada file yang berbeda

  product.id = '001';
  product.nama = 'Carger';
  // product._quantity = 3;   <-- ini tidak bisa di lakukan karna pada file yang berbeda

  // product._getQuantity();  <== tidak bisa di akses karna pada file yang berbeda

}