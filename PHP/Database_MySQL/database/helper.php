<?php


namespace Helper {
    require_once __DIR__."/Config.php";
    use Database\Config;
    use PDO;

    function getConnection():PDO {
        $config = new Config();
        return new PDO("mysql:host=$config->host:$config->port;dbname=$config->database", $config->username, $config->password);
    }

}