<?php

namespace UjunAlRantaui\PHP\Login\Management\Model;

class UserLoginRequest {

    private ?string $id;
    private ?string $password;

    public function __construct(string $id = null, string $password = null){
        $this->id = $id;
        $this->password = $password;
    }

    public function getId(): ?string
    {
        return $this->id;
    }

    public function setId(?string $id): self
    {
        $this->id = $id;

        return $this;
    }

    public function getPassword(): ?string
    {
        return $this->password;
    }

    public function setPassword(?string $password): self
    {
        $this->password = $password;

        return $this;
    }
}