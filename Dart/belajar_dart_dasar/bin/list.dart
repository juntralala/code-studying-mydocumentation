/*
cara pembuatan list:
List<int> listInt = []  ;

var listVar = <int>[]
final listFinal = <int>[]
const listConst = <int>[]

List listDynamic = []

var listDynamicVar = []
final listDynamicFinal = []
Const listDynamicConst = []
*/

import 'dart:typed_data';

void main() {
  var names = <String>[];
  names.add('ujun');
  names.addAll(['Dawi','Madan','Oden']);
  print('list : ${names}');

  print(names.length);
  print(names[0]);

  names[0] = 'Abu';

  print(names[0]);
  print(names);

  names.removeAt(2);

  print(names);

  var listcopy = names ;
  print(names.hashCode.toRadixString(16));
  print(listcopy.hashCode.toRadixString(16));

  List list1 = [1,'ujun','Dawi',3,true];
  print(list1);

  var list2 = [1,2,4,'Ucup','Aban',false];
  print(list2);

}



