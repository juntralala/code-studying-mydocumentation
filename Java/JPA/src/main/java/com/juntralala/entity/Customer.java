package com.juntralala.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.EnumType.STRING;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "customers")
public class Customer {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Transient // <- meng-ignore property agar tidak di insert ke db
    private String fullName;

    @Column(name = "primary_email")
    private String primaryEmail;

    @Enumerated(STRING)
    private CustomerType type;

    public Customer(String id, String name, String primaryEmail) {
        this.id = id;
        this.name = name;
        this.primaryEmail = primaryEmail;
    }
}
