<?php

namespace UjunAlRantaui\PHP\Login\Management\Repository;
use UjunAlRantaui\PHP\Login\Management\Domain\User;

class UserRepository {

    private \PDO $connection;

    public function __construct(\PDO $connection) {
        $this->connection = $connection;
    }

    public function save(User $user): User {
        $statement = $this->connection->prepare("INSERT INTO users(id, username, password) VALUES (?, ?, ?)");
        $statement->execute([
            $user->getId(),
            $user->getName(),
            $user->getPassword()
        ]);
        return $user;
    }

    public function update(User $user): User {
        $statement = $this->connection->prepare("UPDATE users SET username=?, password=? WHERE id=?");
        $statement->execute([
            $user->getName(),
            $user->getPassword(),
            $user->getId()
        ]);
        return $user;
    }

    public function findById(string $id): ?User {
        $statement = $this->connection->prepare("SELECT id, username, password FROM users WHERE id=?" );
        $statement->execute([$id]);

        try {
            if($row = $statement->fetch()){
                $user = new User(
                    $row['id'],
                    $row['username'],
                    $row['password']
                );
                return $user;
            } else {
                return null;
            }
        } finally {
            $statement->closeCursor();
        }
    }

    public function deleteAll(): void {
        $this->connection->exec("DELETE FROM users");
    }

}