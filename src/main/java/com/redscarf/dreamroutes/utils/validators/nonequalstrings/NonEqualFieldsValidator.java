package com.redscarf.dreamroutes.utils.validators.nonequalstrings;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.NonEqualStringsValidator
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 12.05.2022|23:22
 * @Version NonEqualStringsValidator: 1.0
 */

public class NonEqualFieldsValidator implements ConstraintValidator<NonEqualFields, Object> {

    private String baseField;
    private String matchField;

    @Override
    public void initialize(NonEqualFields constraintAnnotation) {
        baseField = constraintAnnotation.baseField();
        matchField = constraintAnnotation.matchField();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        try {
            Object baseFieldValue = getFieldValue(value, baseField);
            Object matchFieldValue = getFieldValue(value, matchField);
            return baseFieldValue != null && !baseFieldValue.equals(matchFieldValue);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private Object getFieldValue(Object object, String fieldName) throws Exception {
        Class<?> clazz = object.getClass();
        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(object);
    }

}
