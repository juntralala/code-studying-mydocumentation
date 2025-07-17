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

  if (hero is MarksmanDPS){
    MarksmanDPS mm_dps = hero as MarksmanDPS;
    print('Hallo Marksman DPS ${mm_dps.nama}');
  } else if (hero is Marksman){
    Marksman mm = hero as Marksman;
    print('Hallo Marksman ${mm.nama}');
  } else {
    print('Hallo Hero ${hero.nama}');
  }

}

void main(){

  sayHello(Hero('Miya')); 
  sayHello(Marksman('Miya')); 
  sayHello(MarksmanDPS('Miya')); 

}