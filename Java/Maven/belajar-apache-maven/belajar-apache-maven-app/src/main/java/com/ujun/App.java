package com.ujun;

import com.google.gson.Gson;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        Gson gson = new Gson();

        Person person = new Person("Muhammad Junaidi");

        String json = gson.toJson(person);
        System.out.println(json);

    }
}
