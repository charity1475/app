package com.steinny.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
public class Student {

    private final UUID id;
    @NotBlank
    private final String regNo;
    private final Integer age;
    private final String firstName;
    private final String lastName;
    private final String course;
    private final String phone;
    private final String email;

    public Student(@JsonProperty("id") UUID id,
                   @JsonProperty("regNo") String regNo,
                   @JsonProperty("age") Integer age,
                   @JsonProperty("firstName") String firstName,
                   @JsonProperty("lastName") String lastName,
                   @JsonProperty("course") String course,
                   @JsonProperty("phone") String phone,
                   @JsonProperty("email") String email) {
        this.id = id;
        this.regNo = regNo;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.phone = phone;
        this.email = email;
    }
}
