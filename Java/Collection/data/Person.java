package data;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Person {
    private String name;
    
    private List<String> hobbies;
    
    public Person(String name) {
        this.name = name;
        hobbies = new ArrayList();
    }
    
    public void addHobby(String hobby) {
        hobbies.add(hobby);
    }
    
    public List<String> getHobbies() {
        return Collections.unmodifiableList(hobbies);
    }
    
    public String getName() {
        return this.name;
    }
}