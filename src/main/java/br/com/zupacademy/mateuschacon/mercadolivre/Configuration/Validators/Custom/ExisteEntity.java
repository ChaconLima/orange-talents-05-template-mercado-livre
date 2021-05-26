package br.com.zupacademy.mateuschacon.mercadolivre.Configuration.Validators.Custom;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.FIELD;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {ExisteEntityValidator.class})
@Target({ FIELD })
@Retention(RUNTIME)
public @interface ExisteEntity  {

    Class<?> domainClass();

    String fieldName();

    String message() default "Não existe registro com o indentificador informado";

    Class<?>[] groups() default { };

    Class<? extends Payload >[] payload() default {};

}
