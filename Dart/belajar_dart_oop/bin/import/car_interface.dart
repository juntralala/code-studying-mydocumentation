class Mobil{

  String nama = '';

  void drive(){

  }

  int getTier(){
    return 0;
  }

}

abstract class HashBrand{

  String getBrand() => ''; 

}

class Avanza implements Mobil, HashBrand{ // <-- pewarisan implimen bisa lebih dari 1 class

  String nama = 'Avanza';

  void drive(){}

  int getTier(){
    return 0;
  }

  String getBrand() => 'Toyota';

}