void main(List<String> args) {

  var upperCase1 = (String text) {
    return text.toUpperCase();
  };

  var lowerCase1 = (String text) {
    return text.toLowerCase();
  };

  var upperCase2 = (String text) => text.toUpperCase();
  
  dynamic lowerCase2 = (String text) => text.toLowerCase();

  print(upperCase1('Humaidi'));
  print(lowerCase1('Humaidi'));


  print(upperCase2('Muhammad Junaidi'));
  print(lowerCase2('Muhammad Junaidi'));


}