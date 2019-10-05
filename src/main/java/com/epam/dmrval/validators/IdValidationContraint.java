package com.epam.dmrval.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdValidationContraint implements ConstraintValidator<IdDigitValid, Integer> {
  @Override
  public void initialize(IdDigitValid constraintAnnotation) {}

  @Override
  public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
    return integer >= 0;
  }
}
