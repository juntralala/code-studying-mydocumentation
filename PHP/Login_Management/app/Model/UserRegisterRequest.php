<?php

namespace UjunAlRantaui\PHP\Login\Management\Model;

class UserRegisterRequest {

    private ?string $id;
    private ?string $name;
    private ?string $password;

    public function __construct(string $id = null,
                                string $name = null,
                                string $password = null) {
        $this->id = $id;
        $this->name = $name;
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

    public function getName(): ?string
    {
        return $this->name;
    }

    public function setName(?string $name): self
    {
        $this->name = $name;

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