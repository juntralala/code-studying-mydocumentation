/*
operator logika dar ada 3 : && || !
*/
void main(){

  print('1 && 1 : ${true && true}');
  print('1 && 0 : ${true && false}');
  print('0 && 1 : ${false && true}');
  print('0 && 0 : ${false && false}\n');

  print('1 || 1 : ${true || true}');
  print('1 || 0 : ${true || false}');
  print('0 || 1 : ${false || true}');
  print('0 || 0 : ${false || false}\n');

  print(!true);
  print(!false);

  
}