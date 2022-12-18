package com.company.model;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    private int id;
    private UserAssignment userAssignment;
    private int rate;
    private LocalDate date;
}
