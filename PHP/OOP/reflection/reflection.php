<?php
/**
 * Reflection adalah membaca struktur kode pada saat aplikasi sedang berjalan
 * Reflection adalah materi yang sabgat panjang dan banyak, sehingga disini kita hanya akan membahas perkenalanya saja
 * Reflection adalah fitur yang biasa digunakan ketika membuat framework
 * https://www.php.net/manual/en/book.reflection.php 
*/

/** Strudi kasus : Membuat Validation Framework
 * Sekarang kita akan coba melakukan studi kasus menggunakan reflection
 * Kita akan membaut Validation Framework menggunakan reflection 
 * validation frameworknya cukup sederhana, kita hanya mengecek apakah properties bernilai null atau tidak. Kalau null atau belum
   di set, kita akan throw ValidationException
 * Tanpa reflection, biasanya untuk melakukan hal ini, kita butuh  pengecekan secara manual
*/

require_once "LoginRequest.php";
require_once "ValidationUtil.php";

$loginRequest = new LoginRequest();
$loginRequest->username = 'ujun';
$loginRequest->password = 'ujun';

// ValidationUtil::validateLoginRequest($loginRequest);

ValidationUtil::validateReflection($loginRequest);

class RegisterUserRequest{
	public ?string $name;
	public ?string $address;
	public ?string $email;
}

$register = new RegisterUserRequest();
$register->name = 'ujun';
$register->address = '127.0.0.1';
$register->email = 'ujun@gmail.com';

ValidationUtil::validateReflection($register);
// ValidationUtil::validateLoginRequest($register); // ini error


