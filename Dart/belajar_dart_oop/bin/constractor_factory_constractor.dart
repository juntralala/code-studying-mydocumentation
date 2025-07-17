class Database{

  Database(){ 
    print('create new databse conection');
  }

  static Database database = Database();

  factory Database.get(){
    return database;
  }

}

void main() {

  var database1 = Database();
  var database2 = Database();

  print(database1);
  print(database2);
  print(database1 == database2);

  print('');

  var database3 = Database.get();
  var database4 = Database.get();

  print(database3);
  print(database4);
  print(database3 == database4);

}