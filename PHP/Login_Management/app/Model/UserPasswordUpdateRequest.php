<?php

namespace UjunAlRantaui\PHP\Login\Management\Model;

class UserPasswordUpdateRequest {
    private ?string $id;
    private ?string $oldPassword;
    private ?string $newPassword;

    public function __construct(?string $id = null,
                                ?string $oldPassword = null,
                                ?string $newPassword = null) {
        $this->id = $id;
        $this->oldPassword = $oldPassword;
        $this->newPassword = $newPassword;
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

    public function getOldPassword(): ?string
    {
        return $this->oldPassword;
    }

    public function setOldPassword(?string $oldPassword): self
    {
        $this->oldPassword = $oldPassword;

        return $this;
    }

    public function getNewPassword(): ?string
    {
        return $this->newPassword;
    }

    public function setNewPassword(?string $newPassword): self
    {
        $this->newPassword = $newPassword;

        return $this;
    }
}