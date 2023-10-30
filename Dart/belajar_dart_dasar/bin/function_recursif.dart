void main() {

  // var deret = (int start, int end) {
  //   return 0 + deret(int start,int end-1);
  // }

  print(deret(9,5));




}

dynamic deret = (int start, int end) {

  if (end == 0 || end == 1){
    return start ;
  }

  return start + deret(start,end-1);
};



