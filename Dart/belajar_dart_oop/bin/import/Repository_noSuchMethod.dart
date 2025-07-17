import 'dart:mirrors';

abstract class CategoryRepository {

  id(String id);
  nama(String nama);
  quantity(int quanity);
  location(String location);

}

class Repository extends CategoryRepository{

  final String _nama;

  Repository(this._nama);

  dynamic noSuchMethod(Invocation invocation){
    var column = MirrorSystem.getName(invocation.memberName);
    var value = invocation.positionalArguments.first;
    var sql = 'select * from $_nama where $column = \'$value\''; 
    print (sql);
  }

}