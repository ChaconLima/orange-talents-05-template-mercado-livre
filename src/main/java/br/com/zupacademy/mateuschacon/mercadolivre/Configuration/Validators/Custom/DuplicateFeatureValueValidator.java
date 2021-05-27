package br.com.zupacademy.mateuschacon.mercadolivre.Configuration.Validators.Custom;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Dtos.NewProductRequest;

public class DuplicateFeatureValueValidator implements ConstraintValidator<DuplicateFeatureValue, NewProductRequest> {

    @Override
    public boolean isValid(NewProductRequest value, ConstraintValidatorContext context) {
        /**
         * 
         */
        return value.duplicateValue();
    }
}
