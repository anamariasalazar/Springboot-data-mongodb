package com.example.springboot.data;

import com.example.springboot.dto.UserDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Document

public class User {
    @Id
    private String id;
    private String name;
    @Indexed(unique = true)
    private String email;
    private String lastName;
    private String createdAt;
    @Transient
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    public User(String id,UserDto userDto) {
        this.id=id;
        this.name = userDto.getName();
        this.email = userDto.getEmail();
        this.lastName = userDto.getEmail();
        this.createdAt = dateTimeFormatter.format(LocalDate.now());

    }

    public User( String id, UserDto userDto, String createdAt) {
        this.id=id;
        this.name = userDto.getName();
        this.email = userDto.getEmail();
        this.lastName = userDto.getEmail();
        this.createdAt = createdAt;
    }


    public String getId() {
        return String.valueOf(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", lastName='" + lastName + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
