package com.epam.dmrval.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProductBuilderMinPriceValidator implements ConstraintValidator<MinPrice, Double> {
  @Override
  public void initialize(MinPrice constraintAnnotation) {}

  @Override
  public boolean isValid(Double price, ConstraintValidatorContext constraintValidatorContext) {
    return price > 0;
  }
}
