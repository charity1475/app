package com.steinny.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.Table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
@Entity
@Table(appliesTo = "student")
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;
    @NotBlank
    private  String regNo;
    private  Integer age;
    private  String firstName;
    private  String lastName;
    private  String course;
    private  String phone;
    private  String email;

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

    public Student(@NotBlank String regNo,
                   Integer age, String firstName,
                   String lastName, String course,
                   String phone, String email) {
        this.regNo = regNo;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.phone = phone;
        this.email = email;
    }

    public Student() {
        
    }
}
