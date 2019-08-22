package com.senla.csvhelper;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

class CsvProcessor {

    private String separator;
    private String filename;
    private String data = "";

    void writeObject(Object obj) throws Exception {

        Class cls = obj.getClass();
        scan(cls);
        for (Field field : cls.getDeclaredFields()) {
            for (Annotation annotation : field.getDeclaredAnnotations()) {
                if (annotation.annotationType().equals(CsvProperty.class)) {

                    CsvProperty csvProperty = (CsvProperty) annotation;
                    field.setAccessible(true);

                    if (csvProperty.propertyType().equals(CsvProperty.Type.SimpleProperty)) {
                        makeLine(String.valueOf(field.get(obj)));

                    } else {
                        if (field.get(obj) != null) {

                            Object subObj = field.get(obj);
                            Field subField = subObj.getClass().getDeclaredField(csvProperty.keyField());
                            subField.setAccessible(true);
                            makeLine(String.valueOf(subField.get(subObj)));

                        } else {
                            makeLine(String.valueOf("null"));
                        }
                    }
                }
            }
        }
        write();
    }

    Object readObject(Object obj, int row) throws Exception {
        Class cls = obj.getClass();
        scan(cls);
        for (Field field : cls.getDeclaredFields()) {
            for (Annotation annotation : field.getDeclaredAnnotations()) {
                if (annotation.annotationType().equals(CsvProperty.class)) {

                    CsvProperty csvProperty = (CsvProperty) annotation;
                    field.setAccessible(true);
                    int col = csvProperty.columnNumber();

                    if (csvProperty.propertyType().equals(CsvProperty.Type.SimpleProperty)) {

                        if (field.getType() == String.class) {
                            field.set(obj, String.valueOf(read(filename, col, row)));
                        } else if (field.getType() == boolean.class || field.getType() == Boolean.class) {
                            field.set(obj, Boolean.valueOf(read(filename, col, row)));
                        } else if (field.getType() == byte.class || field.getType() == Byte.class) {
                            field.set(obj, Byte.valueOf(read(filename, col, row)));
                        } else if (field.getType() == char.class || field.getType() == Character.class) {
                            field.set(obj, read(filename, col, row).charAt(0));
                        } else if (field.getType() == short.class || field.getType() == Short.class) {
                            field.set(obj, Short.valueOf(read(filename, col, row)));
                        } else if (field.getType() == int.class || field.getType() == Integer.class) {
                            field.set(obj, Integer.valueOf(read(filename, col, row)));
                        } else if (field.getType() == long.class || field.getType() == Long.class) {
                            field.set(obj, Long.valueOf(read(filename, col, row)));
                        } else if (field.getType() == float.class || field.getType() == Float.class) {
                            field.set(obj, Float.valueOf(read(filename, col, row)));
                        } else if (field.getType() == double.class || field.getType() == Double.class) {
                            field.set(obj, Double.valueOf(read(filename, col, row)));
                        } else {
                            field.set(obj, "unknown type");
                        }

                    } else {
                        if (!read(filename, col, row).equals("null")) {
                            Class subClass = field.getType();
                            Object subObject = subClass.newInstance();

                            Field subField = subClass.getDeclaredField(csvProperty.keyField());
                            subField.setAccessible(true);
                            subField.set(subObject, Integer.valueOf(read(filename, col, row)));

                            field.set(obj, subObject);
                        }
                    }
                }
            }
        }
        return obj;
    }


    private void scan(Class<?> cls) {
        if (cls.isAnnotationPresent(CsvEntity.class)) {
            CsvEntity csvEntity = cls.getDeclaredAnnotation(CsvEntity.class);
            separator = csvEntity.valuesSeparator();
            filename = csvEntity.filename();
        }
    }

    private void makeLine(String str) {
        data += str + separator;
    }

    private void write() {
        CsvWriterReader writerReader = new CsvWriterReader(filename);
        writerReader.write(data.substring(0, data.length() - separator.length()));
        data = "";
    }

    private String read(String filename, int col, int row) {
        CsvWriterReader writerReader = new CsvWriterReader(filename);
        String line = writerReader.read(row);
        return lineRipper(line, separator, col);
    }

    private String lineRipper(String line, String separator, int col) {
        String[] dataArray = line.split(separator);
        return dataArray[col - 1];
    }
}
