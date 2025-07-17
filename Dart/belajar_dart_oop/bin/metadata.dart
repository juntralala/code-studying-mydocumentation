/*
metadata merupakan fitur yang digunakan untuk menambahkan
informasi tambahan pada kode program yang kita kita buat 
*/

class Example{

  @override
  String toString(){
    return 'Exsample';
  }

  @Deprecated('don\'t use this anymore')
  void doNotUseThis(){}

}

// anotation
// membuat metadata sendiri

class Todo{

  final String todo;
  
  const Todo(this.todo);

}

class Aplication{

  @Todo('Well will be implemented next release')
  String? name; 

  @Todo('Well will be implemented next release')
  void featureA(){}

} 
