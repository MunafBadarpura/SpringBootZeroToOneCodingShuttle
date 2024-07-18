package com.rudradcruze.springbootwebstartw2.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private LocalDate dateOfJoining;
    @JsonProperty("isActive")
    private Boolean isActive;
    private double salary;
    private String role;
    private Integer primeNumber;
    private LocalDate possibleLeaveDate;
    private String creditCardNumber;
    private Float creditCardLimit;
    @JsonProperty("isManager")
    private Boolean isManager;
    private String password;
}
