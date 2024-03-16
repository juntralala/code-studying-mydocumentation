<?php

use PHPUnit\Framework\TestCase;

class RegexTest extends TestCase {

    // test kode untuk mendukung Parameter Path menggunakan Regex
    public function testRegex(){
        $path = "/products/12345/categories/abcdefg";

        // awal dan akhir tidak menggunakan / karena / banyak digunakan di URL
        $pattern = "#^/products/([0-9a-zA-Z]*)/categories/([0-9a-zA-Z]*)$#";
        $result = preg_match($pattern, $path, $variables);
        self::assertEquals(1, $result);
    }

}