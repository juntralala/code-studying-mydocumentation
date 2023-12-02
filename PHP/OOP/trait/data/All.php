<?php

require_once "SayHello.php";
require_once "SayGoodbye.php";
require_once "HashName.php";

trait All{
  use SayHello, SayGoodbye, HashName;
}