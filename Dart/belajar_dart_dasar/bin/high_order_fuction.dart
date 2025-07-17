void main() {

  sayHello("UJUN", filterBadWord);
  sayHello('gila', filterBadWord);
  sayHello('Jack', filterBadWord);

}

void sayHello(String name, String Function(String) filter) {
   var filteredName = filter(name);
   print('hi $filteredName');
}

String filterBadWord(String word) {

  if (word == 'gila') {
    return '****';
  } 

  return word;
}