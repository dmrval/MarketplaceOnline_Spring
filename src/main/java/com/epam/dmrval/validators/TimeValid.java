package com.epam.dmrval.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TimeFieldValidator.class)
public @interface TimeValid {
  String message() default "Time not valid";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
