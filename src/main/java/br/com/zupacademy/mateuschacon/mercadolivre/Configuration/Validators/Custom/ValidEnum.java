package br.com.zupacademy.mateuschacon.mercadolivre.Configuration.Validators.Custom;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.FIELD;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;

@Documented
@Constraint(validatedBy = {ValidEnumValidator.class})
@Target({ FIELD })
@Retention(RUNTIME)
@ReportAsSingleViolation
public @interface ValidEnum {

    Class<? extends Enum<?>> domainClass();

    String message() default "Valor informado errado";

    Class<?>[] groups() default { };

    Class<? extends Payload >[] payload() default {};
}
