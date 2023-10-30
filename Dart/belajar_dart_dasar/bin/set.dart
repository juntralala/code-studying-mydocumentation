/*
set sama seperti list teptapi list 
- Tidak punya index
- Manipulasi lebih terbatas dari list 
- Tidak menerima data yang sama/duplicate
*/

void main() {

  var intSet = <int>{1,2,3,4,5};

  Set<String> dataSet = {'ujun','dawi','adul','ucil'};
  print(dataSet);

  dataSet.add('udin');
  dataSet.add('udin');
  dataSet.add('udin');
  dataSet.addAll({'ipul','iben'});
  dataSet.addAll({'ipul','iben'});

  print(dataSet);
  print(dataSet);

}