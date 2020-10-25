package com.taskmanager.common.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Retention(RUNTIME)
@Constraint(validatedBy = ResourceExistenceValidator.class)
@Target({FIELD, ANNOTATION_TYPE, PARAMETER, TYPE_USE})
public @interface ExistingResource {

    String message() default "Resource is not found";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
