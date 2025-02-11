package com.juntralala;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil{

    private ObjectMapper mapper = new ObjectMapper();

    public ObjectMapper getMapper() {
        return this.mapper;
    }

}
