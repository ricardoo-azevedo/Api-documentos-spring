package br.com.ricardoo_azevedo.api_documentos_spring.config.validations;

import java.util.stream.Stream;

import br.com.ricardoo_azevedo.api_documentos_spring.config.annotations.EnumPattern;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EnumPatternValidation implements ConstraintValidator<EnumPattern, String>{ 


    private Class<? extends Enum<?>> enumClass; 
    
    @Override 
    public void initialize(EnumPattern constraintAnnotation){
        this.enumClass = constraintAnnotation.enumClass();
    }

    @Override 
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null){ 
            return true; 
        }
        return Stream.of(enumClass.getEnumConstants()).anyMatch(e->e.name().equalsIgnoreCase(value));
    
    }
}
