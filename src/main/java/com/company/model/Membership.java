package com.company.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Membership {
    private int id;
    private String membershipName;
    private double price;
}
