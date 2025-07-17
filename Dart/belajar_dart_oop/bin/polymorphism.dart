class Hero{

  String nama = '';

  Hero(this.nama){}

}

class Marksman extends Hero{

  Marksman(super.nama);

}

class MarksmanDPS extends Marksman{

  MarksmanDPS(super.nama);

}

void main(List<String> args){

  // Hero hero = Marksman('Edith'); bisa juga seperti ini
  Hero hero1 = Hero('Ipul');

  print(hero1);

  hero1 = Marksman('Marksman');
  print(hero1);

  hero1 = MarksmanDPS('Marksman');
  print(hero1);

}