<?php

namespace UjunAlRantaui\PHP\Login\Management\Controller;
use PHPUnit\Framework\TestCase;
use UjunAlRantaui\PHP\Login\Management\Config\Database;
use UjunAlRantaui\PHP\Login\Management\Domain\Session;
use UjunAlRantaui\PHP\Login\Management\Domain\User;
use UjunAlRantaui\PHP\Login\Management\Repository\SessionRepository;
use UjunAlRantaui\PHP\Login\Management\Repository\UserRepository;
use UjunAlRantaui\PHP\Login\Management\Service\SessionService;

class HomeControllerTest extends TestCase {

    public HomeController $homeController;
    public UserRepository $userRepository;
    public SessionRepository $sessionRepository;

    protected function setUp():void {
        $this->homeController = new HomeController();
        $connection = Database::getConnection();
        $this->userRepository = new UserRepository($connection);
        $this->sessionRepository = new SessionRepository($connection);

        $this->sessionRepository->deleteAll();
        $this->userRepository->deleteAll();
    }

    public function testGuest() {
        $this->homeController->index();

        $this->expectOutputRegex("/Login Management/");
    }

    public function testUsertLogin() {
        $user = new User("1234567890", "ujun", "12345678");
        $session = new Session(uniqid(), $user->getId());
        $this->userRepository->save($user);
        $this->sessionRepository->save($session);

        $_COOKIE[SessionService::$COOKIE_NAME] = $session->getId();

        $this->homeController->index();

        $this->expectOutputRegex("/Hello ujun/");
        $this->expectOutputRegex("/Logout/");
    }

}