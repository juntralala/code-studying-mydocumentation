package com.juntralala.tostring;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString(exclude = {"id"})
public class Message {
    private String id;
    private String text;
    private String sender;
}
