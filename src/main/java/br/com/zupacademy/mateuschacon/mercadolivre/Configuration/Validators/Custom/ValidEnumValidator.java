package br.com.zupacademy.mateuschacon.mercadolivre.Configuration.Validators.Custom;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidEnumValidator implements ConstraintValidator<ValidEnum,String>{

    private List<String> valueList= new ArrayList<>();

    @Override
    public void initialize(ValidEnum constraintAnnotation) {
        
        Class<? extends Enum<?>> enumClass = constraintAnnotation.domainClass();

        @SuppressWarnings("rawtypes")
        Enum[] enumValArr = enumClass.getEnumConstants();

        for (@SuppressWarnings("rawtypes") Enum enumVal : enumValArr) {
            this.valueList.add(enumVal.toString().toUpperCase());
        }
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
       
        return this.valueList.contains(value.toUpperCase());
        
    }
    
}
