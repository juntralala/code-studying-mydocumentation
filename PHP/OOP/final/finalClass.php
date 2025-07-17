<?php

/**
 * Kata kunci final bisa digunakan pada class, dimana jika kita menggunakan keyword final pada class
   maka class tersebut tidak bisa diwariskan lagi
 * secara otomatis semua class child nya akan error
*/
 
class SocialMedia {
  var $name;
}

final class Facebook extends SocialMedia{}
class FakeFacebook extends Facebook{} // ini error

