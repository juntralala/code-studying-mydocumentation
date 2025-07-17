import 'dart:core';

void main(List<String> args){


  int n = 0; 
  dynamic start = DateTime.now();
  while (n<100000) {

    ++n;
    print(n);

  }

  dynamic end = DateTime.now();

  var intStart = double.parse(start.toString().split(':')[2]);
  var intEnd = double.parse(end.toString().split(':')[2]);
  print(intStart);
  print(intEnd);

  print(intEnd - intStart); 

}