<?php

// contohnya ada di ProductServiceTest.php

/** Singkatnya (penjelasan sendiri)
 * function willReturnArgument() digunakan agar suatu function mengembalikan argument yang diberikan
 * jika arguemnt nya diberikan 0 -> willReturnArgument(0) => maka akan mereturn parameter pertama
 * jika arguemnt nya diberikan 1 -> willReturnArgument(1) => maka akan mereturn parameter kedua
 */

/*  jawaban dari chat GPT-3.5
Dalam konteks PHPUnit, metode `willReturnArgument(0)` digunakan untuk menentukan bahwa nilai yang akan
dikembalikan oleh objek palsu (stub) adalah nilai dari argumen pertama yang diteruskan ke metode tersebut.
Angka 0 dalam `willReturnArgument(0)` merujuk pada indeks (index) argumen yang ingin Anda ambil.

Misalnya, jika metode Anda menerima beberapa argumen dan Anda ingin mengembalikan nilai dari argumen
pertama, Anda menggunakan `willReturnArgument(0)`. Jika Anda ingin mengembalikan nilai dari argumen kedua,
Anda akan menggunakan `willReturnArgument(1)`, dan seterusnya.

Berikut adalah contoh penggunaan `willReturnArgument(0)`:

```php
use PHPUnit\Framework\TestCase;

class ExampleTest extends TestCase {
    public function testStubWithWillReturnArgument() {
        // Membuat objek palsu (stub) untuk sebuah kelas
        $stub = $this->getMockBuilder(SomeClass::class)
                     ->getMock();

        // Mengatur objek palsu (stub) untuk metode tertentu
        $stub->method('someMethod')
             ->willReturnArgument(0);

        // Memanggil metode dan mengharapkan nilai yang sama dengan argumen yang diteruskan
        $this->assertEquals('argument_value', $stub->someMethod('argument_value'));
    }
}
```

Dalam contoh di atas, `willReturnArgument(0)` menandakan bahwa nilai yang akan dikembalikan oleh
`someMethod` adalah nilai dari argumen pertama yang diteruskan ke metode tersebut, yaitu 'argument_value'.
Jadi, hasil panggilan `$stub->someMethod('argument_value')` akan mengembalikan 'argument_value'.
*/