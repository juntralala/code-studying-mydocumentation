<?php

namespace UjunAlRantaui\PHP\Login\Management\Config;

class Database {

    private static ?\PDO $pdo = null;

    public static function getConnection(string $env = "test"): \PDO {
        if (self::$pdo == null){
            // Create new PDO 
            require_once __DIR__ . "/../../config/database.php";
            $config = getDatabaseConfig();
            self::$pdo = new \PDO(
                $config['database'][$env]['url'],
                $config['database'][$env]['username'],
                $config['database'][$env]['password']
            );
        }

        return self::$pdo;
    }

    public static function beginTrunsaction(): void {
        self::$pdo->beginTransaction();
    }

    public static function commitTrunsaction(): void {
        self::$pdo->commit();
    }

    public static function rollbackTrunsaction(): void {
        self::$pdo->rollBack();
    }
}