package com.epam.dmrval.validators;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class StringNotNullValidator implements ConstraintValidator<NotNullStringValue, String> {
  @Override
  public void initialize(NotNullStringValue constraintAnnotation) {}

  @Override
  public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
    return !StringUtils.isEmpty(s);
  }
}
