package edu.wsyu.util;

import org.springframework.stereotype.Component;

@Component
public class LanguagesUtils {


    public boolean isStringType(Class<?> fieldType) {
        return String.class.isAssignableFrom(fieldType);
    }

    public boolean isNumericType(Class<?> fieldType) {
        return Number.class.isAssignableFrom(fieldType);
    }

    public boolean isLongType(Class<?> fieldType) {
        return Long.class.isAssignableFrom(fieldType) || long.class.isAssignableFrom(fieldType);
    }

    public boolean isIntegerType(Class<?> fieldType) {
        return Integer.class.isAssignableFrom(fieldType) || int.class.isAssignableFrom(fieldType);
    }

    public boolean isDoubleType(Class<?> fieldType) {
        return Double.class.isAssignableFrom(fieldType) || double.class.isAssignableFrom(fieldType);
    }

}
