package org.example.entity;

import java.io.File;
import java.util.Set;

public class Entity {

    private long id;
    private String name;
    private Set<String> phones;
    private File file;
    private byte[] blob;

    public Entity() {
    }

    public Entity(long id, String name, Set<String> phones, File file, byte[] blob) {
        this.id = id;
        this.name = name;
        this.phones = phones;
        this.file = file;
        this.blob = blob;
    }

    public Entity(String name, Set<String> phones, File file, byte[] blob) {
        this.name = name;
        this.phones = phones;
        this.file = file;
        this.blob = blob;
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

    public byte[] getBlob() {return blob;}

    public void setBlob(byte[] blob) { this.blob = blob; }
}
