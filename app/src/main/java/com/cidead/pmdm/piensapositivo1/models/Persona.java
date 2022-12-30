package com.cidead.pmdm.piensapositivo1.models;

public class Persona {
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
