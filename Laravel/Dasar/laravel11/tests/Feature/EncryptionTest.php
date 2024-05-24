<?php

namespace Tests\Feature;

use Illuminate\Support\Facades\Crypt;
use Tests\TestCase;


class EncryptionTest extends TestCase{

    public function testEnvryption(): void {
        $name = "Muhammad Junaidi";
        $encrypt = Crypt::encrypt($name);
        var_dump($encrypt);

        $decrypt = Crypt::decrypt($encrypt);

        self::assertEquals("Muhammad Junaidi", $decrypt);
    }

}