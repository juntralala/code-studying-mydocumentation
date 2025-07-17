<?php

require_once "LoginRequest.php";
require_once "ValidationException.php";

// contoh kode reflection
class ValidationUtil {

    static function validateLoginRequest(LoginRequest $loginRequest) {
        if(!isset($loginRequest->username)) {
            throw new ValidationException("Username is null");       
        } elseif(!isset($loginRequest->password)) {
            throw new ValidationException("password is null");       
        } elseif(trim($loginRequest->username) == "") {
            throw new ValidationException("username is empty");       
        } elseif(trim($loginRequest->password) == "") {
            throw new ValidationException("password is empty");       
        }
    }

    static function validateReflection($request) {

        $reflection = new ReflectionClass($request);
        $properties = $reflection->getProperties(ReflectionProperty::IS_PUBLIC); // mengambil semua propery yang public

        foreach($properties as $property) {
            if(!$property->isInitialized($request)) {
                throw new ValidationException("$property->name is not set");
            } elseif(is_null($property->getValue($request))) {
                throw new ValidationException("$property->name is null");
            }
        }

    }
}