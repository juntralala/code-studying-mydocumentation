<?php

namespace UjunAlRantaui\PHP\Login\Management\Model;
use UjunAlRantaui\PHP\Login\Management\Domain\User;

class UserLoginResponse {

    private ?User $user;

    public function __construct(User $user = null) {
        $this->user = $user;
    } 


    public function getUser(): ?User
    {
        return $this->user;
    }

    public function getUserId(): ?string {
        return $this?->user?->getId();
    }

    public function getUserName(): ?string {
        return $this?->user?->getName();
    }

    public function getUserPassword(): ?string {
        return $this?->user?->getPassword();
    }
}