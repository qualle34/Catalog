package com.senla.csvhelper.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(value= RetentionPolicy.RUNTIME)
public @interface CsvEntity {

    String directoryName();
    String valuesSeparator() default ",";
    String entityId() default "";
}