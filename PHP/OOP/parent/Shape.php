<?php

class Shape {
  public function getCorner():int {
    return 0;
  }
}

class rectangle extends Shape {
  public function getCorner():int {
    return 4;
  }
  public function getParentCorner():int{
    return parent::getCorner();
  }
}
