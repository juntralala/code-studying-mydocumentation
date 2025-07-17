abstract class Animal {

  String nama = 'P';

  Animal();

  void run();

} 

class Cat extends Animal{

  void run(){}

}

void main() {

  Cat kucing1 = Cat();

  print(kucing1.nama);

}