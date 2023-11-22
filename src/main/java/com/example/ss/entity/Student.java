package com.example.ss.entity;

import lombok.Data;


@Data
public class Student {

    private String id;
    private String name;
    private String branch;

    public Student(String id, String name, String branch) {
        this.id = id;
        this.name = name;
        this.branch = branch;
    }
}
