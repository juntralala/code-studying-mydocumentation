<?php

namespace UjunAlRantaui\PHP\Login\Management\Service;
use UjunAlRantaui\PHP\Login\Management\Config\Database;
use UjunAlRantaui\PHP\Login\Management\Domain\User;
use UjunAlRantaui\PHP\Login\Management\Exception\ValidationException;
use UjunAlRantaui\PHP\Login\Management\Model\UserLoginRequest;
use UjunAlRantaui\PHP\Login\Management\Model\UserLoginResponse;
use UjunAlRantaui\PHP\Login\Management\Model\UserPasswordUpdateRequest;
use UjunAlRantaui\PHP\Login\Management\Model\UserPasswordUpdateResponse;
use UjunAlRantaui\PHP\Login\Management\Model\UserProfileUpdateRequest;
use UjunAlRantaui\PHP\Login\Management\Model\UserProfileUpdateResponse;
use UjunAlRantaui\PHP\Login\Management\Model\UserRegisterRequest;
use UjunAlRantaui\PHP\Login\Management\Model\UserRegisterResponse;
use UjunAlRantaui\PHP\Login\Management\Repository\UserRepository;

class UserService {

    private UserRepository $repository;

    public function __construct(UserRepository $repository) {
        $this->repository = $repository;
    }

    public function register(UserRegisterRequest $request): UserRegisterResponse {

        try {
            Database::beginTrunsaction();
            $this->validateUserRegistrationRequest($request);
            // validasi apakah id user sudah ada didatabase atau tidak 
            $user = $this->repository->findById($request->getId());
            if($user != null) {
                throw new ValidationException("User Id already exist");
            }

            $user = new User(
                $request->getId(),
                $request->getName(),
                password_hash($request->getPassword(), PASSWORD_BCRYPT)
            );

            $result = $this->repository->save($user);

            Database::commitTrunsaction();
            return new UserRegisterResponse($result);
        } catch (ValidationException $e) {
            Database::rollbackTrunsaction();
            throw $e;
        }
    }

    private function validateUserRegistrationRequest(UserRegisterRequest $request): void {
        // id validation
        if(trim($request->getId()) == ""){
            throw new ValidationException("id is blank");
        } else if(!preg_match("/^[0-9]*$/", $request->getId())){
            throw new ValidationException("id not a number");
        } else if (!preg_match("/.{10,20}/", $request->getId())) {
            throw new ValidationException("id lenght have to between 10 and 20");
        }

        // name validation
        if(trim($request->getName()) == ""){
            throw new ValidationException("name is blank");
        } else if(!preg_match("/^[\w-]*$/", $request->getName())){
            throw new ValidationException("name must alphabet or simbol - and _");
        } else if (!preg_match("/.{4,}/", $request->getName())) {
            throw new ValidationException("minimum lenght of name is 4");
        } else if (!preg_match("/.{0,255}/", $request->getName())) {
            throw new ValidationException("name can't more than 255");
        }

        // password validation
        if(trim($request->getPassword()) == ""){
            throw new ValidationException("password is blank");
        } else if(!preg_match("/^[\w-]*$/", $request->getPassword())){
            throw new ValidationException("invalid password character");
        } else if (!preg_match("/.{8,}/", $request->getPassword())) {
            throw new ValidationException("minimum lenght of password is 8");
        } else if (!preg_match("/.{0,255}/", $request->getPassword())) {
            throw new ValidationException("password can't more than 255");
        }
    }

    public function login(UserLoginRequest $request): UserLoginResponse {
        
        $this->validateUserLoginRequest($request);

        $user = $this->repository->findById($request->getId());
        if (is_null($user)){
            throw new ValidationException("Id or password is wrong");
        }

        if (password_verify($request->getPassword(), $user->getPassword())) {
            $response = new UserLoginResponse($user);
            return $response;
        } else {
            throw new ValidationException("Id or password is wrong");
        }
    }

    private function validateUserLoginRequest(UserLoginRequest $request): void {
        if (is_null($request->getId()) || is_null($request->getPassword()) ||
                trim($request->getId()) == "" || trim($request->getPassword() == "")){
            throw new ValidationException("Id or password can't blank");
        }
    }

    public function updateProfile(UserProfileUpdateRequest $request): UserProfileUpdateResponse {
        $this->validateUserProfileUpdateRequest($request);

        try {
            Database::beginTrunsaction();
            // validasi user exist or not
            $user = $this->repository->findById($request->getId());
            if(is_null($user)) {
                throw new ValidationException("User Not Found!");
            }

            $user->setName($request->getName());
            $this->repository->update($user);
            Database::commitTrunsaction();

            $response = new UserProfileUpdateResponse($user);
            return $response;
        } catch (ValidationException $e) {
            Database::rollbackTrunsaction();
            throw $e;
        }
    }

    private function validateUserProfileUpdateRequest(UserProfileUpdateRequest $request): void {

        // id validation
        if(is_null($request->getId()) || trim($request->getId()) == ""){
            throw new ValidationException("Id can't blank");
        } else if(!preg_match("/^[0-9]*$/", $request->getId())){
            throw new ValidationException("id not a number");
        } else if (!preg_match("/.{10,20}/", $request->getId())) {
            throw new ValidationException("id lenght have to between 10 and 20");
        }

        // name validation
        if(is_null($request->getName()) || trim($request->getName()) == ""){
            throw new ValidationException("Name can't blank");
        } else if(!preg_match("/^[\w-]*$/", $request->getName())){
            throw new ValidationException("name must alphabet or simbol - and _");
        } else if (!preg_match("/.{4,}/", $request->getName())) {
            throw new ValidationException("minimum lenght of name is 4");
        } else if (!preg_match("/.{0,255}/", $request->getName())) {
            throw new ValidationException("name can't more than 255");
        }
    }

    public function updatePassword(UserPasswordUpdateRequest $request): UserPasswordUpdateResponse {
        $this->validateUserPasswordUpdateRequest($request);
        try {
            Database::beginTrunsaction();
            $user = $this->repository->findById($request->getId());
            if(is_null($user)) {
                throw new ValidationException("User is not found");
            }
            
            if(!password_verify($request->getOldPassword(), $user->getPassword())){
                throw new ValidationException("Old password is wrong");
            }

            $user->setPassword(password_hash($request->getNewPassword(), PASSWORD_BCRYPT));
            $this->repository->update($user);

            Database::commitTrunsaction();

            $response = new UserPasswordUpdateResponse($user);
            return $response;
        } catch (ValidationException $e) {
            Database::rollbackTrunsaction();
            throw $e;
        }
    } 

    private function validateUserPasswordUpdateRequest(UserPasswordUpdateRequest $request): void {
        // Id validation
        if (is_null($request->getId()) || trim($request->getId() == "")) {
            throw new ValidationException("Id can't blank");
        }

        // oldPassword validation
        if (is_null($request->getOldPassword()) || trim($request->getOldPassword() == "")) {
            throw new ValidationException("Old password can't blank");
        }

        // newPassword validation
        if(trim(is_null($request->getNewPassword()) || $request->getNewPassword()) == ""){
            throw new ValidationException("New password can't blank");
        } else if(!preg_match("/^[\w-]*$/", $request->getNewPassword())){
            throw new ValidationException("Invalid new password character");
        } else if (!preg_match("/.{8,}/", $request->getNewPassword())) {
            throw new ValidationException("Minimum lenght of new password is 8");
        } else if (!preg_match("/.{0,255}/", $request->getNewPassword())) {
            throw new ValidationException("New password can't more than 255");
        }
    }
}