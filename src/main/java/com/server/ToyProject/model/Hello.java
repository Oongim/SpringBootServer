package com.server.ToyProject.model;

public class Hello {

    private final long id;
    private final String test;

    public Hello(long id, String test) {
        this.id = id;
        this.test = test;
    }

    public long getId() {
        return id;
    }

    public String getTest() {
        return test;
    }
}
