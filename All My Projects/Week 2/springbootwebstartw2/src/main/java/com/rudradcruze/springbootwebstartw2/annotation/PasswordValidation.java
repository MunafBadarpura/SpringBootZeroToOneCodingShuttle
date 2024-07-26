package com.rudradcruze.springbootwebstartw2.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Constraint(validatedBy = PasswordValidator.class)
public @interface PasswordValidation {
    String message() default "The password must contain at least one uppercase letter, one lowercase letter, one special character, and be at least 10 characters long.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
