<?php
/**
 * Enum juga bisa memiliki constant
 * Tetapi enum tidak bisa memiliki property/attribute
*/

enum Gender:string {
    case MALE = "Mr";
    case FEMALE = "Mrs";

    const UNKNOWN = "Uknown";
}

echo Gender::UNKNOWN;       