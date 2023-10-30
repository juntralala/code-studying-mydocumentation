class Shape{

  String nama = 'Shape';

  Shape(this.nama);

  int getCorner() {
    return 0;
  }

}

class Rectangle extends Shape{

  // Rectangle(super.nama);

  Rectangle(String nama): super(nama);


  int getCorner() {
    return 4;
  }

  int getParentCorner() {
    return super.getCorner();
  } 

}

void main() {

  Rectangle kotak = Rectangle('Persegi');

  print(kotak.getCorner());
  print(kotak.getParentCorner());
  print(kotak.nama);

}