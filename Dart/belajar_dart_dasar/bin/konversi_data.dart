void main() {

  print("\x1B[2J\x1B[0;0H");

  String dataString = '100';
  int dataInteger = int.parse(dataString);
  double dataDouble = double.parse(dataString);

  print('Data String\t: ' + dataString);
  print('Data Integer\t: $dataInteger');
  print('Data Double\t: $dataDouble\n');

  var stringFromInt = dataInteger.toString();
  var stringFromDouble = dataDouble.toString();

  print('Integer ke String : $stringFromInt');
  print('Double ke String : $stringFromDouble');

  var doubleFromInteger = dataInteger.toDouble();
  var integerFromDouble = dataDouble.toInt();

  print('\nInteger ke double\t: $doubleFromInteger');
  print('Integer ke double\t: $integerFromDouble');

  // <!--- Konversi Boolean --->

  String dataString2 = 'true';
  bool dataBoolean = dataString2 == 'true';
  String stringFromBoolean = dataBoolean.toString(); 

  print('\nString\t\t\t: $dataString2');
  print('Boolean\t\t\t: $dataBoolean');
  print('String from Boolean\t: $stringFromBoolean');

}