package com.epam.dmrval.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StringNotNullValidator.class)
public @interface NotNullStringValue {
  String message() default "The field must not be empty";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
