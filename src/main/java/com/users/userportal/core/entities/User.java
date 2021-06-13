package com.users.userportal.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private int id;
    @NotEmpty(message = "First Name is required")
    private String firstName;
    @NotEmpty(message = "Last Name is required")
    private String lastName;
    @Email(message = "Email must be valid")
    @NotEmpty(message = "Email is required")
    private String email;
}