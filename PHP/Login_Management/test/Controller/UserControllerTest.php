<?php

namespace UjunAlRantaui\PHP\Login\Management\Controller {

    require_once __DIR__ . "/../Helper/helper.php";

    use PHPUnit\Framework\TestCase;
    use UjunAlRantaui\PHP\Login\Management\Config\Database;
    use UjunAlRantaui\PHP\Login\Management\Domain\Session;
    use UjunAlRantaui\PHP\Login\Management\Domain\User;
    use UjunAlRantaui\PHP\Login\Management\Repository\UserRepository;
    use UjunAlRantaui\PHP\Login\Management\Repository\SessionRepository;
    use UjunAlRantaui\PHP\Login\Management\Service\SessionService;
    
    class UserControllerTest extends TestCase {
    
        private UserController $userController;
        private UserRepository $userRepository;
        private SessionRepository $sessionRepository;
    
        protected function setUp(): void {
            $this->userController = new UserController();
            $this->userRepository = new UserRepository(Database::getConnection());
            $this->sessionRepository = new SessionRepository(Database::getConnection());

            $this->sessionRepository->deleteAll();
            $this->userRepository->deleteAll();

            putenv("mode=test");
        }
    
        public function testRegister(): void {
            $this->userController->register();
    
            $this->expectOutputRegex("/Register/");
            $this->expectOutputRegex("/Id/");
            $this->expectOutputRegex("/Name/");
            $this->expectOutputRegex("/Pasword/");
            $this->expectOutputRegex("/Register New User/");
        }
    
        public function testPostRegisterSuccess(): void {
    
            $_POST['id']        = "1234567890";
            $_POST['name']      = "Ezon";
            $_POST['password']  = "12345678";
    
            $this->userController->postRegister();
    
            $this->expectOutputRegex("#/users/login#");
        }
    
        public function testPostRegisterValidationError(): void {
            
            $_POST['id']        = "";
            $_POST['name']      = "Ezon";
            $_POST['password']  = "1245678";
    
            $this->userController->postRegister();
    
            $this->expectOutputRegex("/Register/");
            $this->expectOutputRegex("/Id/");
            $this->expectOutputRegex("/Name/");
            $this->expectOutputRegex("/Pasword/");
            $this->expectOutputRegex("/Register New User/");
            $this->expectOutputRegex("/id is blank/");
        }
    
        public function testPostRegisterDuplicate(): void {
    
            $user = new User("12345678901", "Kajun", "12345678");
            $this->userRepository->save($user);
    
            $_POST['id']        = "12345678901";
            $_POST['name']      = "Kajun";
            $_POST['password']  = "12345678";
    
            $this->userController->postRegister();
    
            $this->expectOutputRegex("/Register/");
            $this->expectOutputRegex("/Id/");
            $this->expectOutputRegex("/Name/");
            $this->expectOutputRegex("/Pasword/");
            $this->expectOutputRegex("/Register New User/");
            $this->expectOutputRegex("/User Id already exist/");
        }

        public function testLogin(): void {

            $this->userController->login();

            $this->expectOutputRegex("/Login User/");
            $this->expectOutputRegex("/Id/");
            $this->expectOutputRegex("/Password/");
            $this->expectOutputRegex("/Login/");
        }

        public function testLoginSuccess(): void {

            $user = new User("1234567890", "UJUN", password_hash("12345678", PASSWORD_BCRYPT));
            $this->userRepository->save($user);

            $_POST['id'] = "1234567890";
            $_POST['password'] = "12345678";

            $this->userController->loginPost();

            $this->expectOutputRegex("#Location: /#");
            $this->expectOutputRegex("#X-UJUN-SESSION: #");
        }

        public function testLoginNotFound(): void {

            $_POST['id'] = "tidak_ada";
            $_POST['password'] = "orang";

            $this->userController->loginPost();

            $this->expectOutputRegex("/Login User/");
            $this->expectOutputRegex("/Id/");
            $this->expectOutputRegex("/Password/");
            $this->expectOutputRegex("/Login/");

            $this->expectOutputRegex('/Id or password is wrong/');
        }

        public function testLoginWrongPassword(): void {

            $user = new User("1234567890", "UJUN", password_hash("actual_password", PASSWORD_BCRYPT));
            $this->userRepository->save($user);

            $_POST['id'] = "1234567890";
            $_POST['password'] = "wrong_password";

            $this->userController->loginPost();

            $this->expectOutputRegex("/Login User/");
            $this->expectOutputRegex("/Id/");
            $this->expectOutputRegex("/Password/");
            $this->expectOutputRegex("/Login/");

            $this->expectOutputRegex('/Id or password is wrong/');
        }

        public function testUpdateProfile(): void {
            $user = new User("1234567890", "UJUN", password_hash("actual_password", PASSWORD_BCRYPT));
            $session = new Session(uniqid(), $user->getId());
            $this->userRepository->save($user);
            $this->sessionRepository->save($session);
            $_COOKIE[SessionService::$COOKIE_NAME] = $session->getId();

            $this->userController->updateProfile();

            $this->expectOutputRegex("/Profile/");
            $this->expectOutputRegex("/Id/");
            $this->expectOutputRegex("/123456890/");
            $this->expectOutputRegex("/Name/");
            $this->expectOutputRegex("/UJUN/");
        }

        public function testPostUpdateProfileSuccess(): void {
            
            $user = new User("1234567890", "UJUN", password_hash("actual_password", PASSWORD_BCRYPT));
            $session = new Session(uniqid(), $user->getId());
            $this->userRepository->save($user);
            $this->sessionRepository->save($session);
            $_COOKIE[SessionService::$COOKIE_NAME] = $session->getId();
            $_POST['name'] = "OZON";

            $this->userController->postUpdateProfile();

            $this->expectOutputRegex("/Location: \//");

            $result = $this->userRepository->findById($user->getId());
            $this->assertEquals($_POST['name'], $result->getName());
        }

        public function testPostUpdateProfileValidationError(): void {
            
            $user = new User("1234567890", "UJUN", password_hash("actual_password", PASSWORD_BCRYPT));
            $session = new Session(uniqid(), $user->getId());
            $this->userRepository->save($user);
            $this->sessionRepository->save($session);
            $_COOKIE[SessionService::$COOKIE_NAME] = $session->getId();
            $_POST['name'] = "";

            $this->userController->postUpdateProfile();
            
            $this->expectOutputRegex("/Profile/");
            $this->expectOutputRegex("/Id/");
            $this->expectOutputRegex("/123456890/");
            $this->expectOutputRegex("/Name/");
            $this->expectOutputRegex("/UJUN/");

            $this->expectOutputRegex("/Name can't blank/");
        }

        public function testUpdatePassword(): void {
            $user = new User("1234567890", "ujun", "12345678");
            $session = new Session(uniqid(), $user->getId());
            $this->userRepository->save($user);
            $this->sessionRepository->save($session);
            $_COOKIE[SessionService::$COOKIE_NAME] = $session->getId();

            $this->userController->updatePassword();

            $this->expectOutputRegex("/Update Password/");
            $this->expectOutputRegex("/Id/");
            $this->expectOutputRegex("/Old Password/");
            $this->expectOutputRegex("/New Password/");
            $this->expectOutputRegex("/Change Password/");
        }

        public function testPostUpdatePasswordSuccess(): void {
            $user = new User("1234567890", "ujun", password_hash("old_password", PASSWORD_BCRYPT));
            $session = new Session(uniqid(), $user->getId());
            $this->userRepository->save($user);
            $this->sessionRepository->save($session);
            $_COOKIE[SessionService::$COOKIE_NAME] = $session->getId();
            $_POST['oldPassword'] = "old_password";
            $_POST['newPassword'] = "new_password";

            $this->userController->postUpdatePassword();

            $this->expectOutputString("Location: /");
        }

        public function testPostUpdatePassswordValidationError(): void {
            $user = new User("1234567890", "ujun", password_hash("12345678", PASSWORD_BCRYPT));
            $session = new Session(uniqid(), $user->getId());
            $this->userRepository->save($user);
            $this->sessionRepository->save($session);
            $_COOKIE[SessionService::$COOKIE_NAME] = $session->getId();
            $_POST['oldPassword'] = "12345678";
            $_POST['newPassword'] = "";

            $this->userController->postUpdatePassword();

            $this->expectOutputRegex("/Update Password/");
            $this->expectOutputRegex("/Id/");
            $this->expectOutputRegex("/Old Password/");
            $this->expectOutputRegex("/New Password/");
            $this->expectOutputRegex("/Change Password/");

            $this->expectOutputRegex("/New password can't blank/");
        }

        public function testPostUpdatePassswordWrongOldPassword(): void {
            $user = new User("1234567890", "ujun", password_hash("old_password", PASSWORD_BCRYPT));
            $session = new Session(uniqid(), $user->getId());
            $this->userRepository->save($user);
            $this->sessionRepository->save($session);
            $_COOKIE[SessionService::$COOKIE_NAME] = $session->getId();
            $_POST['oldPassword'] = "wrong_old_password";
            $_POST['newPassword'] = "new_password";

            $this->userController->postUpdatePassword();

            $this->expectOutputRegex("/Update Password/");
            $this->expectOutputRegex("/Id/");
            $this->expectOutputRegex("/Old Password/");
            $this->expectOutputRegex("/New Password/");
            $this->expectOutputRegex("/Change Password/");

            $this->expectOutputRegex("/Old password is wrong/");
        }
    }
}