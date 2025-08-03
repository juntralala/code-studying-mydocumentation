<?php

namespace UjunAlRantaui\PHP\Login\Management\Model;
use UjunAlRantaui\PHP\Login\Management\Domain\User;

class UserRegisterResponse {
    
    private User $user;

    public function __construct(User $user) {
        $this->user = $user;
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