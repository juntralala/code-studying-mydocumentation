<?php

namespace UjunAlRantaui\PHP\Login\Management\Service;
use PHPUnit\Framework\TestCase;
use UjunAlRantaui\PHP\Login\Management\Config\Database;
use UjunAlRantaui\PHP\Login\Management\Domain\User;
use UjunAlRantaui\PHP\Login\Management\Exception\ValidationException;
use UjunAlRantaui\PHP\Login\Management\Model\UserLoginRequest;
use UjunAlRantaui\PHP\Login\Management\Model\UserPasswordUpdateRequest;
use UjunAlRantaui\PHP\Login\Management\Model\UserProfileUpdateRequest;
use UjunAlRantaui\PHP\Login\Management\Model\UserRegisterRequest;
use UjunAlRantaui\PHP\Login\Management\Repository\SessionRepository;
use UjunAlRantaui\PHP\Login\Management\Repository\UserRepository;

class UserServiceTest extends TestCase {

    private UserService $service;
    private UserRepository $userRepository;
    private SessionRepository $sessionRepository;

    protected function setUp(): void {
        $connection = Database::getConnection();
        $this->userRepository = new UserRepository($connection);
        $this->sessionRepository = new SessionRepository($connection);
        $this->service = new UserService($this->userRepository);

        $this->sessionRepository->deleteAll();
        $this->userRepository->deleteAll();
    }

    public function testRegisterSuccess(): void {
        $request = new UserRegisterRequest("1234567890", "ujun", "12345678");
        $response = $this->service->register($request);

        $this->assertEquals($request->getId(), $response->getUserId());
        $this->assertEquals($request->getName(), $response->getUserName());
        $this->assertNotEquals($request->getPassword(), $response->getUserPassword());

        $this->assertTrue(password_verify($request->getPassword(), $response->getUserPassword()));
    }

    public function testRegisterFailed(): void {
        $this->expectException(ValidationException::class);
        $request = new UserRegisterRequest("", "", "");
        $this->service->register($request);
    }

    public function testRegisterDuplicate(): void {
        
        $user = new User("0987654321", "jendral", "ngak boleh");
        $this->userRepository->save($user);

        $this->expectException(ValidationException::class);

        $request = new UserRegisterRequest("0987654321", "jendral", "ngak boleh");
        $this->service->register($request);
    }

    public function testLoginNotFound(): void {

        $this->expectException(ValidationException::class);
        
        $request = new UserLoginRequest("not found", "not found");

        $this->service->login($request);
    }

    public function testLoginWrongPassword(): void {

        $this->expectException(ValidationException::class);

        $user = new User("12345678910", "Ujun", password_hash("actual_password", PASSWORD_BCRYPT));
        $this->userRepository->save($user);

        $request = new UserLoginRequest("123458910", "wrong_password");
        $response = $this->service->login($request);
    }

    public function testLoginSuccess(): void {

        $user = new User("12345678910", "Ujun", password_hash("actual_password", PASSWORD_BCRYPT));
        $this->userRepository->save($user);

        $request = new UserLoginRequest("12345678910", "actual_password");
        $response = $this->service->login($request);

        $this->assertEquals($request->getId(), $response->getUserId());
        $this->assertTrue(password_verify($request->getPassword(), $response->getUserPassword()));
    }

    public function testUpdateSuccess(): void {
        $user = new User(
            id:"12345678910",
            name:"Ujun",
            password: password_hash("actual_password", PASSWORD_BCRYPT));
        $this->userRepository->save($user);
        $request = new UserProfileUpdateRequest(
            id: $user->getId(),
            name: "OZON"
        );

        $response = $this->service->updateProfile($request);

        $result = $this->userRepository->findById($user->getId());
        $this->assertEquals($result->getName(), $response->getUserName());
    }

    public function testUpdateValidationError(): void {
        $this->expectException(ValidationException::class);

        $user = new User(
            id:"12345678910",
            name:"Ujun",
            password: password_hash("actual_password", PASSWORD_BCRYPT));
        $this->userRepository->save($user);
        $request = new UserProfileUpdateRequest(
            id: null,
            name: null
        );

        $response = $this->service->updateProfile($request);
    }

    public function testUpdateNotFound(): void {
        $this->expectException(ValidationException::class);
        $this->expectExceptionMessage("Not Found");

        $request = new UserProfileUpdateRequest(
            id: "1234567890",
            name: "orang"
        );

        $response = $this->service->updateProfile($request);
    }

    public function testUpdatePasswordSuccess(): void {
        $user = new User(
            id:"1234567890",
            name:"Ujun",
            password: password_hash("12345678", PASSWORD_BCRYPT));
        $this->userRepository->save($user);

        $request = new UserPasswordUpdateRequest(
            id: $user->getId(), 
            oldPassword: "12345678", 
            newPassword: "1sampai8");

        $response = $this->service->updatePassword($request);

        $this->assertEquals($request->getId(), $response->getUserId());
        $this->assertEquals($user->getName(), $response->getUserName());
        $this->assertTrue( password_verify($request->getNewPassword(), $response->getUserPassword()) );
    }

    public function testUpdatePasswordWrongOldPassword(): void {
        $this->expectException(ValidationException::class);
        $this->expectExceptionMessage("Old password is wrong");

        $user = new User(
            id:"1234567890",
            name:"Ujun",
            password: password_hash("actual_oldPassword", PASSWORD_BCRYPT));
        $this->userRepository->save($user);

        $request = new UserPasswordUpdateRequest(
            id: $user->getId(), 
            oldPassword: "12345678", 
            newPassword: "wrong_newPassword");

        $response = $this->service->updatePassword($request);
    }

    public function testUpdatePasswordNotFound(): void {
        $this->expectException(ValidationException::class);
        $this->expectExceptionMessage("User is not found");

        $request = new UserPasswordUpdateRequest(
            id: "not_found", 
            oldPassword: "12345678", 
            newPassword: "87654321");

        $response = $this->service->updatePassword($request);
    }

}