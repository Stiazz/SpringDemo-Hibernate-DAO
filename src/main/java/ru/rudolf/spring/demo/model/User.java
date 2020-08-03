package ru.rudolf.spring.demo.model;

public class User {
    private Long id;

    private String name;

    private String password;

    private String email;

    public User () {
    }

    public User (String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public String getName () {
        return name;
    }

    public String getEmail () {
        return email;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    @Override
    public String toString () {
        return "User{" +
                "name='" + name + '\'' +
                "email='" + email + '\'' +
                '}';
    }
}
