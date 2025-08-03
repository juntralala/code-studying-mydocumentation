<?php

namespace UjunAlRantaui\PHP\Login\Management\Domain;

class User {

    private string $id;
    private string $name;
    private string $password;

    public function __construct(string $id,string $name,string $password) {
        $this->setId($id);
        $this->setName($name);
        $this->setPassword($password);
    }


    public function getId(): string
    {
        return $this->id;
    }

    public function setId(string $id): self
    {
        if(trim($id) == ""){
            throw new \Exception("id is blank");
        } else if(!preg_match("/^[0-9]*$/", $id)){
            throw new \Exception("id not a number");
        } else if (!preg_match("/.{10,20}/", $id)) {
            throw new \Exception("id lenght have to between 10 and 20");
        }

        $this->id = $id;
        return $this;
    }

    public function getName(): string
    {
        return $this->name;
    }

    public function setName(string $name): self
    {
        if(trim($name) == ""){
            throw new \Exception("name is blank");
        } else if(!preg_match("/^[\w-]*$/", $name)){
            throw new \Exception("name must alphabet or simbol - and _");
        } else if (!preg_match("/.{4,}/", $name)) {
            throw new \Exception("minimum lenght of name is 4");
        } else if (!preg_match("/.{0,255}/", $name)) {
            throw new \Exception("name can't more than 255");
        }

        $this->name = $name;
        return $this;
    }

    public function getPassword(): string
    {
        return $this->password;
    }

    public function setPassword(string $password): self
    {
        $this->password = $password;
        return $this;
    }
}