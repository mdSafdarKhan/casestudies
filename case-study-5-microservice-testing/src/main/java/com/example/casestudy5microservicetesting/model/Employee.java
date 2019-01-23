package com.example.casestudy5microservicetesting.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String designation;
    private Long salary;
}
