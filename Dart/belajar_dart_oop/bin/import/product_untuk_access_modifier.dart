/* variable menggunakan underscore(_) tidak bisa diaccess di file yang lain*/
class Product{

  String id ='';
  String nama = '';
  int _quantity = 0;

  int _getQuantity() {
    return _quantity;
  }

}

void main(List<String> args) {

  var product = Product()
  ..id = '0001'
  ..nama = 'Laptop'
  .._quantity = 2;  // <-- bisa dilakukan karna pada file yang sama

  product.id = '001';
  product.nama = 'Carger';
  product._quantity = 3;   // <-- bisa dilakukan karna pada file yang sama

  product._getQuantity();  // <== bisa di akses karna pada file yang sama

}