<?php

namespace Tests\Frature;

use Illuminate\Log\Logger;
use Illuminate\Support\Facades\Log;
use Illuminate\Support\Facades\Validator;
use PHPUnit\Framework\Attributes\Test;
use Psr\Log\LoggerInterface;
use Tests\TestCase;

/** Error Message
 * Saat kita melakukan validasi, kita perlu tahu key mana yang bermasalah, dan apa pesan error nya
 * Kita bisa mendapatkan detail dari error menggunakan function messages(), errors(), atau getMessageBag(), yang semuanya akan mengembalikan object sama yaitu class MessageBag
 * https://laravel.com/api/10.x/Illuminate/Support/MessageBag.html 
 */

/** methods
 * messages()
 * errors()
 * getMessageBag()
 */

class ErrorMessageTest extends TestCase
{
    public function testErrorMessage(): void
    {
        $datas = [
            'username' => 'admin',
            'password' => ''
        ];
        $rules = [
            'username' => 'required',
            'password' => 'required'
        ];

        $validator = Validator::make($datas, $rules);

        self::assertTrue($validator->fails());
        $message = $validator->getMessageBag(); // mendapatkan error message

        $this->logger->info($message->toJson(JSON_PRETTY_PRINT));
    }

}