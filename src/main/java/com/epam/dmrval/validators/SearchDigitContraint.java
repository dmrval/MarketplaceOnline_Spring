package com.epam.dmrval.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/** Author - Damir_Valeev */
public class SearchDigitContraint implements ConstraintValidator<SearchDigitValid, Double> {
  @Override
  public void initialize(SearchDigitValid constraintAnnotation) {}

  @Override
  public boolean isValid(Double aDouble, ConstraintValidatorContext constraintValidatorContext) {
    return aDouble >= 0;
  }
}
