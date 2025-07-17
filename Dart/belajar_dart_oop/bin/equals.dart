import 'import/hero.dart';

void main(List<String> args){

  var hero1 = Tank.crowdcontrol()
    ..nama = 'Atlas';
  
  var hero2 = Tank.crowdcontrol()
    ..nama = 'Atlas';

  print(hero1 == hero2);

  print(hero1.hashCode);
  print(hero2.hashCode);

}