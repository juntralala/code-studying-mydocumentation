package com.juntralala.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    private String id;

    private String name;

    @OneToOne
    @PrimaryKeyJoinColumn(
            name = "id",
            referencedColumnName = "id"
    )
    private Credential credential;

    @OneToOne(mappedBy = "user")
    private Wallet wallet;
}
