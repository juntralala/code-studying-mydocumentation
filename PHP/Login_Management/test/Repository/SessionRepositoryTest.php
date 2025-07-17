<?php

namespace UjunAlRantaui\PHP\Login\Management\Repository;
use PHPUnit\Framework\TestCase;
use UjunAlRantaui\PHP\Login\Management\Config\Database;
use UjunAlRantaui\PHP\Login\Management\Domain\Session;
use UjunAlRantaui\PHP\Login\Management\Domain\User;

class SessionRepositoryTest extends TestCase {

    private SessionRepository $sessionRepository;
    private UserRepository $userRepository;
    
    protected function setUp(): void {
        $this->sessionRepository = new SessionRepository(Database::getConnection());
        $this->userRepository = new UserRepository(Database::getConnection());
        $this->sessionRepository->deleteAll();
        $this->userRepository->deleteAll();
    }

    public function testSaveSuccess(): void {
        $user = new User("1234567890", "ujun", "12345678"); 
        $this->userRepository->save($user);

        $session = new Session(uniqid(), "1234567890");
        $this->sessionRepository->save($session);   

        $result = $this->sessionRepository->findById($session->getId());

        $this->assertEquals($session->getId(), $result->getId());
        $this->assertEquals($session->getUserId(), $result->getUserId());
    }

    public function testFindByIdNotFound(): void {
        $session = new Session(uniqid(), "1234567890"); 
        $result = $this->sessionRepository->findById($session->getId());

        $this->assertNull($result);
    }

    
    public function testDeleteByIdSuccess(): void {
        $user = new User(
            id:"1234567890",
            name:"ujun",
            password:"12345678"); 
        $this->userRepository->save($user);

        $session = new Session(
            id:uniqid(),
            userId:"1234567890");
        $this->sessionRepository->save($session); 

        $result = $this->sessionRepository->findById($session->getId());

        $this->assertEquals($session->getId(), $result->getId());
        $this->assertEquals($session->getUserId(), $result->getUserId());

        $this->sessionRepository->deleteById($session->getId());

        $result = $this->sessionRepository->findById($session->getId());

        $this->assertNull($result);
    }
}