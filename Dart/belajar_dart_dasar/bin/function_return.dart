void main() {
  int angka1 = sum([6,2,9,4]);
  print(angka1);

  int angka2 = sum2([5,5]); 
  print(angka2);

}


int sum(List<int> numbers) {
  int hasil = 0;
  for (int value in numbers) {
    hasil += value;
  }
  return hasil;
}

List<int> myFunction() {
  print('nice');
  return [1,2];
}

dynamic myfuction2() {
  return false;
}

// function short expression
int sum2(List<int> angka) => angka[0] + angka[1];