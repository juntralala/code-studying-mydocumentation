<?php

require_once "LoginRequest.php";
require_once "ValidationException.php";

function validateLoginRequest(LoginRequest $loginRequest) {
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