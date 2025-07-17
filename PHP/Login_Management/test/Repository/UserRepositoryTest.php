<?php

namespace UjunAlRantaui\PHP\Login\Management\Repository;
use PHPUnit\Framework\TestCase;
use UjunAlRantaui\PHP\Login\Management\Config\Database;
use UjunAlRantaui\PHP\Login\Management\Domain\User;

class UserRepositoryTest extends TestCase {

    private UserRepository $userRepository;
    private SessionRepository $sessionRepository;

    protected function setUp(): void {
        $this->userRepository = new UserRepository(Database::getConnection());
        $this->sessionRepository = new SessionRepository(Database::getConnection());
        $this->sessionRepository->deleteAll();
        $this->userRepository->deleteAll();
    }

    function testSaveSuccess(): void {
        $user = new User("1234567890", "ujun", "12345678");

        $result = $this->userRepository->save($user);

        $this->assertEquals($user->getId(), $result->getId());
        $this->assertEquals($user->getName(), $result->getName());
        $this->assertEquals($user->getPassword(), $result->getPassword());
    }

    function testFindByIdNotFound(): void {
        $result = $this->userRepository->findById("not found");
        
        $this->assertNull($result);
    }

    public function testUpdateSuccess(): void {
        $user = new User("1234567890", "ujun", "12345678");
        $this->userRepository->save($user);
        $user->setName("OZON");

        $this->userRepository->update($user);
        $result = $this->userRepository->findById("1234567890");

        $this->assertEquals($user->getId(), $result->getId());
        $this->assertEquals($user->getName(), $result->getName());
        $this->assertEquals($user->getPassword(), $result->getPassword());
    }
}