package com.steinny.app.model;

import lombok.Data;

import java.util.UUID;


@Data
public class Student {

    private final UUID uuid = UUID.randomUUID();
    private final String regNo;
    private final Integer age;
    private final String firstName;
    private final String lastName;
    private final String course;
    private final String phone;
    private final String email;
}
