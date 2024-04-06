<?php

namespace UjunAlRantaui\PHP\Login\Management\Middleware {

    require_once __DIR__ . "/../Helper/helper.php";

    use PHPUnit\Framework\TestCase;
    use UjunAlRantaui\PHP\Login\Management\Config\Database;
    use UjunAlRantaui\PHP\Login\Management\Domain\Session;
    use UjunAlRantaui\PHP\Login\Management\Domain\User;
    use UjunAlRantaui\PHP\Login\Management\Repository\SessionRepository;
    use UjunAlRantaui\PHP\Login\Management\Repository\UserRepository;
    use UjunAlRantaui\PHP\Login\Management\Service\SessionService;
    
    class MustNotLoginMiddlewareTest extends TestCase {
    
        private MustNotLoginMiddleware $mustNotLoginMiddleware;
        private UserRepository $userRepository;
        private SessionRepository $sessionRepository;
    
        protected function setUp(): void {
            $this->mustNotLoginMiddleware = new MustNotLoginMiddleware();
            $this->userRepository = new UserRepository(Database::getConnection());
            $this->sessionRepository = new SessionRepository(Database::getConnection());

            $this->sessionRepository->deleteAll();
            $this->userRepository->deleteAll();

            putenv("mode=test");
        }
    
        public function testBefore(): void {
            $this->mustNotLoginMiddleware->before();

            $this->expectOutputString("");
        }

        public function testBeforeUserLogin(): void {
            $user = new User("1234567890","Fulan", "12345678");
            $session = new Session(uniqid(), "1234567890");
            $this->userRepository->save($user);
            $this->sessionRepository->save($session);
            $_COOKIE[SessionService::$COOKIE_NAME] = $session->getId();

            $this->mustNotLoginMiddleware->before();

            $this->expectOutputRegex("#Location: /#");
        }
    }
}