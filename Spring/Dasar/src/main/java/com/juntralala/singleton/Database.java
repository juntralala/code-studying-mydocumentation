package com.juntralala.singleton;

public class Database {

    private static Database database = null;

    private Database() {

    }

    public static Database getInstance() {
        if(database == null) {
            database = new Database();
        }
        return database;
    }

}
