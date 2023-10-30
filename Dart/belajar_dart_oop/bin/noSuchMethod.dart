import 'import/Repository_noSuchMethod.dart';

void main() {

  CategoryRepository repository = Repository('product');
  var repository2 = Repository('product'); // <== sama saja dengan yang di atas

  repository.id('01');
  repository.nama('Laptop');
  repository.quantity(12);
  repository.location('Jakarta');

}