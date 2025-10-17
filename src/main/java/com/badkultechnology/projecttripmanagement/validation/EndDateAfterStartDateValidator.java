package com.badkultechnology.projecttripmanagement.validation;

import com.badkultechnology.projecttripmanagement.DTO.EndDateAfterStartDate;
import com.badkultechnology.projecttripmanagement.DTO.TripDTO;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EndDateAfterStartDateValidator implements ConstraintValidator<EndDateAfterStartDate, TripDTO> {
	@Override
	public boolean isValid(TripDTO dto, ConstraintValidatorContext context) {
		if (dto == null)
			return true;
		if (dto.getStartDate() == null || dto.getEndDate() == null)
			return true; // @NotNull handles nulls
		return !dto.getEndDate().isBefore(dto.getStartDate());
	}
}
