package com.epam.dmrval.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IdValidationContraint.class)
public @interface IdDigitValid {
  String message() default "Id is not valid";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
