<?php

namespace UjunAlRantaui\PHP\Login\Management\Controller;
use UjunAlRantaui\PHP\Login\Management\App\View;
use UjunAlRantaui\PHP\Login\Management\Config\Database;
use UjunAlRantaui\PHP\Login\Management\Exception\ValidationException;
use UjunAlRantaui\PHP\Login\Management\Model\UserLoginRequest;
use UjunAlRantaui\PHP\Login\Management\Model\UserPasswordUpdateRequest;
use UjunAlRantaui\PHP\Login\Management\Model\UserProfileUpdateRequest;
use UjunAlRantaui\PHP\Login\Management\Model\UserRegisterRequest;
use UjunAlRantaui\PHP\Login\Management\Repository\SessionRepository;
use UjunAlRantaui\PHP\Login\Management\Repository\UserRepository;
use UjunAlRantaui\PHP\Login\Management\Service\SessionService;
use UjunAlRantaui\PHP\Login\Management\Service\UserService;

class UserController {

    private UserService $userService;
    private SessionService $sessionService;
    
    public function __construct() {
        $connection = Database::getConnection();
        $userRepository = new UserRepository($connection);
        $sessionRepository = new SessionRepository($connection);
        $this->userService = new UserService($userRepository);
        $this->sessionService = new SessionService($sessionRepository, $userRepository);
    }

    public function register(): void {
        View::render("User/register", [
            'title' => "Register New User"
        ]);
    }

    public function postRegister(): void {
        $request = new UserRegisterRequest(
            $_POST['id'],
            $_POST['name'],
            $_POST['password']
        );

        try {
            $this->userService->register($request);
            // redirect
            View::redirect("/users/login");
        } catch (ValidationException $e) {  
            View::render("User/register", [
                'title' => "Register New User",
                'error' => $e->getMessage()
            ]);
        }
    }

    public function login(): void {
        View::render("User/login", [
            'title' => "Login User"
        ]);
    }

    public function loginPost(): void {

        $request = new UserLoginRequest($_POST['id'], $_POST['password']);

        try {
            $response = $this->userService->login($request);
            $this->sessionService->create($response->getUserId());
            View::redirect("/");
        } catch (ValidationException $e) {
            View::render("User/login", [
                'title' => "Register User",
                'error' => $e->getMessage()
            ]);
        }
    }

    public function logout(): void {
        $this->sessionService->destroy();
        View::redirect('/');
    }

    public function updateProfile(): void {
        $user = $this->sessionService->current();

        View::render("User/profile", [
            'title' => "Update Profile User",
            'user' => [
                'id' => $user->getId(),
                'name' => $user->getName()
            ]
        ]);
    }

    public function postUpdateProfile(): void {
        $user = $this->sessionService->current();
        $request = new UserProfileUpdateRequest(
            $user->getId(),
            $_POST['name']
        );

        try {
            $this->userService->updateProfile($request);
            View::redirect('/');
        } catch (ValidationException $e) {
            View::render("User/profile", [
                'title' => "Update User Profile",
                'error' => $e->getMessage()
            ]);
        }
    }

    public function updatePassword(): void {
        $user = $this->sessionService->current();
        View::render("User/password", [
            'title' => "Update Password",
            'user' => [
                'id' => $user->getId()
            ]
        ]);
    }

    public function postUpdatePassword(): void {
        $user = $this->sessionService->current();
        $request = new UserPasswordUpdateRequest(
            id: $user->getId(),
            oldPassword: $_POST['oldPassword'],
            newPassword: $_POST['newPassword']
        );

        try {
            $this->userService->updatePassword($request);
            View::redirect("/");
        } catch(ValidationException $e) {
            View::render("User/password", [
                'title' => "Update Password",
                'error' => $e->getMessage(),
                'user' => [
                    'id' => $user->getId()
                ]
            ]);
        }
    }

}