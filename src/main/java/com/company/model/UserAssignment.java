package com.company.model;

import com.company.model.enums.Assignment_Status;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserAssignment {
    private int id;
    private User to_user;
    private User from_trainer;
    private Exercise exercise;
    private int quantity;
    private Nutrition nutrition;
    private LocalDate date;
    private Assignment_Status status;

}
