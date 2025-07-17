<?php 

namespace UjunAlRantaui\PHP\Login\Management\Service;

require_once __DIR__ . "/../Helper/helper.php";

use PHPUnit\Framework\TestCase;
use UjunAlRantaui\PHP\Login\Management\Domain\Session;
use UjunAlRantaui\PHP\Login\Management\Domain\User;
use UjunAlRantaui\PHP\Login\Management\Repository\SessionRepository;
use UjunAlRantaui\PHP\Login\Management\Config\Database;
use UjunAlRantaui\PHP\Login\Management\Repository\UserRepository;

class SessionServiceTest extends TestCase{

    private SessionService $service;
    private SessionRepository $sessionRepository;
    private UserRepository $userRepository;

    protected function setUp(): void {
        $this->sessionRepository = new SessionRepository(Database::getConnection());
        $this->userRepository = new UserRepository(Database::getConnection());
        
        $this->sessionRepository->deleteAll();
        $this->userRepository->deleteAll();
        
        $this->service = new SessionService($this->sessionRepository, $this->userRepository);
    }

    public function testCreate(): void {
        $user = new User("1234567890", "ujun", "12345678");
        $this->userRepository->save($user);

        $session = $this->service->create($user->getId());

        $sessionId = $session->getId();
        $this->expectOutputRegex("/X-UJUN-SESSION: $sessionId/");
    }

    public function testDestroy(): void {
        $user = new User("1234567890", "ujun", "12345678");
        $this->userRepository->save($user);
        $session = new Session(uniqid(), $user->getId());
        $this->sessionRepository->save($session);
        $_COOKIE[SessionService::$COOKIE_NAME] = $session->getId();
        
        $this->service->destroy();
        
        $sessionId = $session->getId();
        $this->expectOutputRegex("/X-UJUN-SESSION: $sessionId/");
        $result = $this->sessionRepository->findById($sessionId);
        $this->assertNull($result);
    }

    public function testCurrent(): void {
        $user = new User("1234567890", "ujun", "12345678");
        $this->userRepository->save($user);
        $session = new Session(uniqid(), $user->getId());
        $this->sessionRepository->save($session);
        $_COOKIE[SessionService::$COOKIE_NAME] = $session->getId();

        $resultUser = $this->service->current();

        $this->assertEquals($session->getUserId(), $resultUser->getId());
    }
}