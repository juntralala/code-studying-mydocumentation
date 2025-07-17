mixin Playable{

  String nama = '';

  void play(){
    print('play ${nama}');
  }

}

mixin Stoppable on Multimedia{

  String nama = '';

  void stop(){

    print('Stop $nama');

  }

}

abstract class Multimedia{}

class Video extends Multimedia with Playable, Stoppable{}

class Audio extends Multimedia with Playable, Stoppable{}

void main(List<String> args){

  // Multimedia media1 = Multimedia();

  // media1.play();
  // media1.stop(); // <-- ini error

  Video media2 = Video()
    ..nama = 'Belajar Dart';

  print(media2.nama);
  media2.play();
  media2.stop();

  Audio media3 = Audio()
    ..nama = 'Lepaskan';
  
  media3.play();
  media3.stop();

}