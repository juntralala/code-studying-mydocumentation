package com.juntralala.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "students")
@Data
@NamedQueries({
        @NamedQuery(name= "Student.findAll", query = "SELECT s FROM Student s"),
        @NamedQuery(name= "Student.findAllByName", query = "SELECT s FROM Student s WHERE name=:name")
})
@NamedNativeQueries({
        @NamedNativeQuery(name = "Student.native.findAll", query = "SELECT * FROM students", resultClass = Student.class)
})
public class Student {

    @Id
    private String id;

    private String name;

    @Version
    private Long version;

}
