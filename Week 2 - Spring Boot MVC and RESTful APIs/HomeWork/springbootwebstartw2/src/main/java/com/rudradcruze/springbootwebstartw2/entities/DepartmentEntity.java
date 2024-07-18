package com.rudradcruze.springbootwebstartw2.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;
    private String email;
    private String imageUrl;

    @JsonProperty("isActive")
    private Boolean isActive;

    private LocalDate createdAt;
    private String description;
    private Double budget;
    private Integer employeeCount;
    private String manager;
    private Integer averageAge;
}
