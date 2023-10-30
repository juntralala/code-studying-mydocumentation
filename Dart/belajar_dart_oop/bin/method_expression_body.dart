class computer {

  void startUp() => print("Computer is starting");
  void shutDown() => print("Computer is shutingdown");
  String getOS() => 'Window';

}

extension p on computer {

  void sapa () {
    print("Selamat data di ${getOS()}");
  }

} 

void main() {

  var myComputer = computer();

  myComputer.startUp();
  myComputer.shutDown();

  print(myComputer.getOS());
  myComputer.sapa();

}