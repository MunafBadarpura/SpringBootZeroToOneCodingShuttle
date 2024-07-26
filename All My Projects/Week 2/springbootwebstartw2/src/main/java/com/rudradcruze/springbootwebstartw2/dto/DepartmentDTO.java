package com.rudradcruze.springbootwebstartw2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {

    private Long id;

    @NotBlank(message = "Title of the department cannot be blank")
    @NotEmpty(message = "Title of the department cannot be empty")
    @NotNull(message = "Title of the department cannot be null")
    @Size(min = 2, max = 50, message = "Title of the department should be in range: [3,50]")
    private String title;

    @Email(message = "Email should be a valid email")
    @NotBlank(message = "Email of the employee cannot be blank")
    private String email;

    @URL(message = "Image URL should be a valid URL")
    private String imageUrl;

    @JsonProperty("isActive")
    @AssertTrue(message = "The department should be active")
    private Boolean isActive;

    @PastOrPresent(message = "Created at should be in past or present")
    private LocalDate createdAt;

    @Length(min = 10, max = 1000, message = "Description should be between 10 and 1000 characters")
    private String description;

    @DecimalMin(value = "1000.00", message = "Budget should be at least 1000")
    @DecimalMax(value = "1000000.00", message = "Budget should be at most 1000000")
    @Digits(integer = 7, fraction = 2, message = "Budget should be in the form of xxxxxx.xx")
    private Double budget;

    @PositiveOrZero(message = "Employee count should be positive or zero")
    private Integer employeeCount;

    @Null(message = "Manager should be null")
    private String manager;

    @Min(value = 20, message = "Average age should be at least 20")
    @Max(value = 60, message = "Average age should be at most 60")
    private Integer averageAge;
}
