package com.rudradcruze.springbootwebstartw2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rudradcruze.springbootwebstartw2.annotation.EmployeeRoleValidation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Long id;

//    @NotNull(message = "Required field in employee: name") // if not present the field
//    @NotEmpty(message = "Name of the employee cannot be empty") // if present but null "" empty string
    @NotBlank(message = "Name of the employee cannot be blank")
    @Size(min = 3, max = 10, message = "Name of the character in name should be in range: [3,10]m")
    private String name;

    @NotBlank(message = "Email of the employee cannot be blank")
    @Email(message = "Email should be a valid email")
    private String email;

    @NotNull(message = "Age of the employee cannot be null")
    @Max(value = 60, message = "Age of the employee cannot be grater then 60")
    @Min(value = 18, message = "Age of the employee cannot be less then 18")
    private Integer age;

    @NotBlank(message = "Role of the employee cannot be blank")
//    @Pattern(regexp = "^(ADMIN|USER)$", message = "Role of employee should be either ADMIN or USER")
    @EmployeeRoleValidation
    private String role; // ADMIN, USER

    @PositiveOrZero(message = "Salary of the employee cannot be negative")
    @Digits(integer = 6, fraction = 2, message = "Salary of the employee in the form of xxxxxx.xx")
    @DecimalMin(value = "100.50", message = "Salary of the employee should be grater 100.50")
    @DecimalMax(value = "100000.99", message = "Salary of the employee must be less then 100000.99")
    private double salary;

    @PastOrPresent(message = "Date of joining should be in past or present")
    private LocalDate dateOfJoining;

    @AssertTrue(message = "The employee should be active")
    @JsonProperty("isActive")
    private Boolean isActive;
}
