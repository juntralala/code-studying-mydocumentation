/*
operator type tes ada 3 : as is is! 
*/
void main() {
  var varInt = 100;

  print(varInt is int);
  print(varInt is double);
  print(varInt is String);
  print(varInt is bool);
  
  print('');

  print(varInt is! int);
  print(varInt is! double);
  print(varInt is! String);
  print(varInt is! bool);

}