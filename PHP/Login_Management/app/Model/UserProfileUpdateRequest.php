<?php

namespace UjunAlRantaui\PHP\Login\Management\Model;

class UserProfileUpdateRequest {

    private ?string $id;
    private ?string $name;
    
    public function __construct(?string $id = null,
                                ?string $name = null) {
        $this->id = $id;
        $this->name = $name;
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
}