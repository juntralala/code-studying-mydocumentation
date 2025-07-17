void main(List<String> args) {
  String nama = '';

  for (var value in args) {
    nama += value + ((value == args[args.length-1]) ? '' : ' ');
  }

  print('nama saya : $nama');

}