package org.example.entity;

import java.io.File;
import java.util.Set;

public class Entity {

    private int id;
    private String name;
    private Set<String> phones;
    private File file;

    public Entity() {
    }

    public Entity(String name) {
        this.name = name;
    }

    public Entity(int id, String name, Set<String> phones, File file) {
        this.id = id;
        this.name = name;
        this.phones = phones;
        this.file = file;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getPhones() {
        return phones;
    }

    public void setPhones(Set<String> phones) {
        this.phones = phones;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
