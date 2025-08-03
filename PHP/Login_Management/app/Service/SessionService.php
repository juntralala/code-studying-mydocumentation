<?php

namespace UjunAlRantaui\PHP\Login\Management\Service;
use UjunAlRantaui\PHP\Login\Management\Domain\Session;
use UjunAlRantaui\PHP\Login\Management\Domain\User;
use UjunAlRantaui\PHP\Login\Management\Repository\SessionRepository;
use UjunAlRantaui\PHP\Login\Management\Repository\UserRepository;

class SessionService {

    public static string $COOKIE_NAME = "X-UJUN-SESSION";

    private SessionRepository $sessionRepository;
    private UserRepository $userRepository;

    public function __construct(SessionRepository $sessionRepository, UserRepository $userRepository) {
        $this->sessionRepository = $sessionRepository;
        $this->userRepository = $userRepository;
    }

    public function create(string $userId): Session {
        $session = new Session(
            id: uniqid(),
            userId: $userId
        );

        $this->sessionRepository->save($session);  
        
        setcookie(self::$COOKIE_NAME, $session->getId(), time() + 60 * 60 * 24  * 30, "/");

        return $session;
    }

    public function destroy(): void { 
        $sessionId = $_COOKIE[self::$COOKIE_NAME];
        $this->sessionRepository->deleteById($sessionId);

        setcookie(self::$COOKIE_NAME, $sessionId, 1, "/");
    }

    public function current(): ?User {
        $sessionId = $_COOKIE[self::$COOKIE_NAME] ?? '';
        $session = $this->sessionRepository->findById($sessionId);

        if(is_null($session)) {
            return null;
        }

        $user = $this->userRepository->findById($session->getUserId());
        return $user;
    }

}