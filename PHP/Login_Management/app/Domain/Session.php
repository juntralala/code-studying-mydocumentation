<?php

namespace UjunAlRantaui\PHP\Login\Management\Domain;

class Session {

    private string $id;
    private string $userId;

    public function __construct(string $id, string $userId){
        $this->validateUserId($userId);
        $this->id = $id;
        $this->userId = $userId;
    }


    public function getId(): string
    {
        return $this->id;
    }

    public function setId(string $id): self
    {
        $this->id = $id;

        return $this;
    }

    public function getUserId(): string
    {
        return $this->userId;
    }

    public function setUserId(string $userId): self
    {
        $this->validateUserId($userId);
        $this->userId = $userId;

        return $this;
    }

    protected function validateUserId(string $id): void {
        if(trim($id) == ""){
            throw new \Exception("id is blank");
        } else if(!preg_match("/^[0-9]*$/", $id)){
            throw new \Exception("id not a number");
        } else if (!preg_match("/.{10,20}/", $id)) {
            throw new \Exception("id lenght have to between 10 and 20");
        }
    }
}