<?php

namespace UjunAlRantaui\PHP\Login\Management\Middleware;
use UjunAlRantaui\PHP\Login\Management\App\View;
use UjunAlRantaui\PHP\Login\Management\Config\Database;
use UjunAlRantaui\PHP\Login\Management\Repository\SessionRepository;
use UjunAlRantaui\PHP\Login\Management\Repository\UserRepository;
use UjunAlRantaui\PHP\Login\Management\Service\SessionService;

class MustNotLoginMiddleware implements Middleware{ 

    private SessionService $sessionService;

    public function __construct(){
        $userRepository = new UserRepository(Database::getConnection());
        $sessionRepository = new SessionRepository(Database::getConnection());
        $this->sessionService = new SessionService($sessionRepository, $userRepository);
    }

    public function before(): void{

        $user = $this->sessionService->current();
        if(isset($user)){
            View::redirect("/");
        }
    }

}