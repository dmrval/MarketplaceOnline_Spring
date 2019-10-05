package com.epam.dmrval.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class TimeFieldValidator implements ConstraintValidator<TimeValid, String> {
  @Override
  public void initialize(TimeValid constraintAnnotation) {}

  @Override
  public boolean isValid(String string, ConstraintValidatorContext constraintValidatorContext) {
    try {
      LocalDateTime timeLocal = LocalDateTime.parse(string);
      if (timeLocal.isBefore(LocalDateTime.now())) {
        return false;
      }
    } catch (DateTimeParseException d) {
      return false;
    }
    return true;
  }
}
