package com.badkultechnology.projecttripmanagement.DTO;

import java.lang.annotation.Documented;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.badkultechnology.projecttripmanagement.validation.EndDateAfterStartDateValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

// This method is used for valid dates of trips that is check the valid starting date and end date of trip 

@Documented
@Constraint(validatedBy = EndDateAfterStartDateValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface EndDateAfterStartDate {
	String message() default "End date must be after or equal to start date";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
