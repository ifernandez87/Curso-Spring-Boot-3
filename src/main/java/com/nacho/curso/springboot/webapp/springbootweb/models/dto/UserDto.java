package com.nacho.curso.springboot.webapp.springbootweb.models.dto;

public class UserDto {

    private String title;
    private String name;
    private String lastname;

    public UserDto(String title, String name, String lastname) {
        this.title = title;
        this.name = name;
        this.lastname = lastname;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
