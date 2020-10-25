package com.taskmanager.common.validation;

import org.springframework.core.io.Resource;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.io.File;
import java.io.IOException;

public class ResourceExistenceValidator implements ConstraintValidator<ExistingResource, Resource> {

    @Override
    public void initialize(ExistingResource constraintAnnotation) {
    }

    @Override
    public boolean isValid(Resource resource, ConstraintValidatorContext context) {
        try {
            File file = resource.getFile();
            return file.exists();
        } catch (IOException e) {
            return false;
        }
    }

}
