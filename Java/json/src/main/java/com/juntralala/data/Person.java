package com.juntralala.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class Person {
    private String id;
    @JsonProperty("full_name")
    private String name;
    @JsonIgnore
    private String password;
    private List<String> hobbies;
    private Address address;

    @JsonFormat(pattern = "dd-MM-yyyy") // <- tidak pakai waktu
    private Date createdAt;
    private Date updatedAt;

    public Person() {};

    public Person(String id, String name, List<String> hobbies, Address address) {
        this.id = id;
        this.name = name;
        this.hobbies = hobbies;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
