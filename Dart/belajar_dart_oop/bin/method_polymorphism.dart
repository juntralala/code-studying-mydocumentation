class Hero{
  String nama = '';

  Hero(this.nama);

}

class Marksman extends Hero{

  Marksman(super.nama);

}

class MarksmanDPS extends Marksman{

  MarksmanDPS(super.nama);

}

void sayHello(Hero hero){ 

  print('Hallo ${hero.nama}');

}

void main(){

  sayHello(Hero('Miya')); 
  sayHello(Marksman('Miya')); 
  sayHello(MarksmanDPS('Miya')); 

}