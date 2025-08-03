abstract class Hero{

  String nama = '';
  String role = '';
  String splesialis = '';

  String toString() {
    return '''Nama\t\t: $nama
Role\t\t: $role
Spelsialis\t: $splesialis''';
  }

  bool operator ==(Object other){
    if (other is Hero){
      if (nama != other.nama) {
        return false;
      } else if (role != other.role) {
        return false;
      }else if (splesialis != other.splesialis) {
        return false;
      }
      return true;
    } else {
    return false;
    }
  }

  int get hashCode{
    var result = nama.hashCode;
    result += role.hashCode;
    result += splesialis.hashCode;
    return result;
  }

}

class Tank extends Hero{

  Tank(){
    super.role = 'Tank';
  }

  Tank.crowdcontrol(){
    super.role ='tank'.replaceFirst('t', 'T');
    super.splesialis = 'Crowd Control';
  }

} 