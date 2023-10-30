class ValidationException implements Exception {

  String message;

  ValidationException(this.message);

}

class Validation{

  static void validate(String userName, String password){

    if (userName == ''){
      throw  ValidationException('Username is blank');
    } else if (password == ''){
      throw ValidationException('Password is balnk');
    } if (userName != 'ujun' || password != '123'){
      throw Exception('Gagal log in');
    }
    // valid
  }

}

void main(List<String> args){
  try {

    Validation.validate('ujun', '1234');
  
  } on ValidationException catch (e,st) {
    print('Validation error');
    print(e.message);
    print(st.toString());
  } on Exception catch (e,st){
    print(e.toString());
    print(st.toString());
  }

  // menangkap semua exception

  try {
    Validation.validate('', '');
  } catch (Exception){
    print(Exception);
  }

  print('selesai');

}