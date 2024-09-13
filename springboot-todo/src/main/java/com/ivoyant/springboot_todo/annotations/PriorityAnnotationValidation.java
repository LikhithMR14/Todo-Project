package com.ivoyant.springboot_todo.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {PriorityAnnotationValidator.class})
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface PriorityAnnotationValidation {
    String message() default "The Priority should be 'HIGH' or 'LOW'";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
