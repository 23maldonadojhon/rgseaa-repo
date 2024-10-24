package es.aesan.rgseaa.model.commom.validation.constraints;


import es.aesan.rgseaa.model.commom.validation.validator.NifValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = NifValidator.class)
public @interface NIF {
	String message() default "{nif.invalid}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
