package com.ebookteria.identity.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class DobValidator  implements ConstraintValidator<DobConstraint, LocalDate> {

    private int min;

    @Override
    public void initialize(DobConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        min = constraintAnnotation.min();
    }

    @Override
    public boolean isValid(LocalDate inputDate, ConstraintValidatorContext constraintValidatorContext) {
        if (Objects.isNull(inputDate)) return true;

        long years = ChronoUnit.YEARS.between(inputDate, LocalDate.now());
        return years >= min;
    }
}
