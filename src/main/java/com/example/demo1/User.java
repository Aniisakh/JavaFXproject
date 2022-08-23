package com.example.demo1;

public class User {
    private String firstname;
    private String lastname;
    private String login;
    private String password;
    private String region;
    private String gender;

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public User(String firstname, String lastname, String login, String password, String region, String gender) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.login = login;
        this.password = password;
        this.region = region;
        this.gender = gender;
    }

    public User()
    {

    }
    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getRegion() {
        return region;
    }

    public String getGender() {
        return gender;
    }
}
