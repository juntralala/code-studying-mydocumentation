class imutablePoint{

  final int a;
  final int b;

  const imutablePoint(this.a, this.b);

}

void main() {

  imutablePoint angka =  const imutablePoint(2, 4);
  imutablePoint angka2 = const imutablePoint(2, 4);
  var angka3 = imutablePoint(2, 4);
  var angka4 = imutablePoint(2, 4);

  print(angka.a);
  print(angka.b);
  print(angka2.a);
  print(angka2.b);

  print((angka == angka2));
  print((angka3 == angka4));

}