package org.example.springproject.model;

public class Person {

    private long id;
    private String name;
    private String surname;
    private int year;
    private String login;
    private String password;
    private String email;
    private int phone;

    public Person(){ }

    public Person(String name, String surname, int year, String login, String password, String email, int phone) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.login = login;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public Person(long id, String name, String surname, int year, String login, String password, String email, int phone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.login = login;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + year +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                '}';
    }
}
