package com.example.pr17;

public class Group {
    private int id;
    private String name;
    private int countStudent;

    public Group(int id, String name, int countStudent) {
        this.id = id;
        this.name = name;
        this.countStudent = countStudent;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCountStudent() {
        return countStudent;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountStudent(int countStudent) {
        this.countStudent = countStudent;
    }
}
