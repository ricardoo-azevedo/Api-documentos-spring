package br.com.ricardoo_azevedo.api_documentos_spring.config.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.ricardoo_azevedo.api_documentos_spring.config.validations.EnumPatternValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = EnumPatternValidation.class) 
@Target({ElementType.FIELD, ElementType.PARAMETER}) 
@Retention(RetentionPolicy.RUNTIME) 
public @interface EnumPattern{

    Class<? extends Enum<?>> enumClass();

    String message() default("Os valores enum presentes são invalidaos!"); 

    Class<?>[] groups() default {}; 

    Class<? extends Payload>[] payload() default {}; 

}