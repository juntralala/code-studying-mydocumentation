class Hero{

  String nama = '';

  Hero(this.nama);

  void intro(){
    print('Hallo, namaku $nama');
  }

}

class Marksman extends Hero{

  String role= 'Marksman';

  Marksman(String nama) :super(nama);

  void intro(){
    print('''Hallo, namaku $nama
aku memiliki role $role''');
  }

}

void main() {

  Hero hero1 = Hero('Layla');

  hero1.intro(); // <-- intro dari Parent class

  print('');

  Marksman hero2 = Marksman('Clint');

  hero2.intro();// <-- intro dari child classs

}

