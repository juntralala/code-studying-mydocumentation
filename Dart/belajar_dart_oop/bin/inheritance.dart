class Hero{

  String nama ='';
  String role ='';

  Hero(this.nama, this.role);

  void intro(){

    print('''Hallo, namaku $nama
dan role ku bertipe $role''');

  }

}

class Marksman extends Hero{

  String spesialis = ''; 

  Marksman(String nama, this.spesialis) : super(nama,'Marksman');

}

void main() {

  Marksman hero1 = Marksman('Layla','Burst');

  hero1.intro();
  print(hero1.spesialis);

}