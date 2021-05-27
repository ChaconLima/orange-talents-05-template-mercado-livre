package br.com.zupacademy.mateuschacon.mercadolivre.Configuration.Validators.Custom;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.*;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {DuplicateFeatureValueValidator.class})
@Target({ TYPE })
@Retention(RUNTIME)
public @interface DuplicateFeatureValue {

    String message() default "Existem caracteristicas duplicadas na Lista";

    Class<?>[] groups() default { };

    Class<? extends Payload >[] payload() default {};


}
