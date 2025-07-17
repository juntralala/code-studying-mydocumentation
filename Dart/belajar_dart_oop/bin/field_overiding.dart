class Hero{

  String nama = '';
  String role = 'unknown';

  Hero(this.nama);

}

class Marksman extends Hero{

  String role = 'Marksman' ;

  Marksman(String nama): super(nama);

}

void main() {

  Hero hero1 = Hero('Alucard');

  print(hero1.role);

  Marksman hero2 = Marksman('Claude');

  print(hero2.role);

}