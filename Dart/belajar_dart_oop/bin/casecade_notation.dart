class Hero{

  String? nama;
  String? role;
  String? spesialis;
  String? ras;

}

void main() {

  // Tanpa casecade notasion
  Hero hero1 = Hero();
  hero1.nama = 'Argus';
  hero1.role = 'Fighter';
  hero1.spesialis = 'Damage';
  hero1.spesialis = 'Angel';

  // casecade notasion
  Hero hero2 = Hero()
    ..nama = 'Alice'
    ..role = 'Mage'
    ..spesialis = 'DPS/Regen'
    ..ras = 'Blood Demon';
  
}