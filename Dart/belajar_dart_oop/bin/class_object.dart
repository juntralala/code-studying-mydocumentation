class Hero{}

void main(List<String> args) {

  var angka = 100;
  print(angka.toString());

  var hero1 = Hero();

  print(hero1.hashCode);
  print(hero1.runtimeType);
  print(hero1.toString());
  print(hero1.noSuchMethod);

}