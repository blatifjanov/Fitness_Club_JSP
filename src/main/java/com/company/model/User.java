package com.company.model;

import com.company.model.enums.Role;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDate dateOfBirth;
    private String phone;
    private String gender;
    private Role role;
    private double balance;

}
