package org.example.entity;

public class User {

    private int id;
    private String firstName;
    private String lastName;
    int bornYear;

    public User() {
    }

    public User(int id, String firstName, String lastName, int bornYear) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bornYear = bornYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBornYear() {
        return bornYear;
    }

    public void setBornYear(int bornYear) {
        this.bornYear = bornYear;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", bornYear=" + bornYear +
                '}';
    }
}
