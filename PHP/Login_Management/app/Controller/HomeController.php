<?php

namespace UjunAlRantaui\PHP\Login\Management\Controller;

use UjunAlRantaui\PHP\Login\Management\App\View;
use UjunAlRantaui\PHP\Login\Management\Config\Database;
use UjunAlRantaui\PHP\Login\Management\Repository\SessionRepository;
use UjunAlRantaui\PHP\Login\Management\Repository\UserRepository;
use UjunAlRantaui\PHP\Login\Management\Service\SessionService;

class HomeController  {

    private SessionService $sessionService;

    public function __construct(){
        $connection = Database::getConnection();
        $sessionRepository = new SessionRepository($connection);
        $userRepository = new UserRepository($connection);
        $this->sessionService = new SessionService($sessionRepository, $userRepository);
    }

    function index(): void {

        $user = $this->sessionService->current();
        if($user === null) {
            View::render("Home/index", [
                'title' => "PHP Login Management"
            ]);
        } else {
            View::render("Home/dashboard", [
                'title' => "PHP Login Management",
                "user" => [
                    "name" => $user->getName()
                ]
            ]);
        }
    }

}