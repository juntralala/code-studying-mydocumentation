

void main() {
  //for loop
  for (int i=0 ;i<10;i++) {
    print('perulangan ke-$i');
  }

  print('\nPashol\n');
  // while loop
  int index = 0;
  while(index<=10) {
    print('While loop ke-$index');
    index++;
  }

  // do while loop
  int j = 0;
  do {
    j++;
    print('execusi ke-$j');
  } while (j<10);

  // for in
  List<String> names = ['Muhammad Junaidi','Ahmad Badawi','Muhammad Lutfi Ariffien'];
  for (var value in names) {
    print(value);
  }

}