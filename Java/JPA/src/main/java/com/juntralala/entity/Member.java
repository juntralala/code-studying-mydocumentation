package com.juntralala.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "members")
@Data
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    private String email;

    @Embedded
    private Name name;

    @Transient
    private String fullName;

    @ElementCollection
    @CollectionTable(name = "hobbies", joinColumns = {
            @JoinColumn(name = "member_id", referencedColumnName = "id")
    })
    @Column(name = "name")
    private List<String> hobbies;

    @PostLoad
    public void listenPostLoad() {
        this.fullName = name.getTitle() + ". " + name.getFirstName() + " " + name.getMiddleName() + " " + name.getLastName();
    }
}
