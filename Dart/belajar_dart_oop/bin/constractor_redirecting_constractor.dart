class Hero{
  String heroName = 'No name';
  String? role;
  int power;

  Hero(this.heroName, this.role, this.power){}

  Hero.setHeroName(String name) : this(name,'No Role',0);

  Hero.setRole(String role): this('No Name',role,0);

  Hero.setPower(int power): this('No Name','No Role',power);

}

void main(List<String> args) {

  Hero hero1 = Hero('Alucard', 'Figther', 30);

  print('Nama hero : ${hero1.heroName}');
  print('Role Hero : ${hero1.role}');
  print('Attack    : ${hero1.power}\n');

  Hero hero2 = Hero.setHeroName('Zilong');

  print('Nama hero : ${hero2.heroName}');
  print('Role Hero : ${hero2.role}');
  print('Attack    : ${hero2.power}\n');

  Hero hero3 = Hero.setRole('Marksman');

  print('Nama hero : ${hero3.heroName}');
  print('Role Hero : ${hero3.role}');
  print('Attack    : ${hero3.power}\n');

  Hero hero4 = Hero.setPower(20);

  print('Nama hero : ${hero4.heroName}');
  print('Role Hero : ${hero4.role}');
  print('Attack    : ${hero4.power}\n');


} 