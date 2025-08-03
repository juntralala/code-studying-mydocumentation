package com.juntralala.entity;

import jakarta.persistence.Lob;

public class Image {
    private String name;

    @Lob
    private String description;

    @Lob // dengan anotasi @Lob secara otomatis di translate oleh persistense api ke String atau array byte
    private byte[] bytes;
}
