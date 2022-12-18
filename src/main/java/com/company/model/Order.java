package com.company.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int id;
    private User user;
    private Payment payment;
    private UserAssignment userAssignment;
    private LocalDate date;

}
