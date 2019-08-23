package com.senla.csvhelper;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;

class CsvProcessor {

    private boolean isHeaderExists;
    private boolean isSubHeaderExists;

    void writeObject(Object obj) throws Exception {

        if (!isHeaderExists) {
            makeHeader(obj);
            isHeaderExists = true;
        }

        Class cls = obj.getClass();
        HashMap<Integer, String> dataLine = new HashMap<>();
        String separator = "";
        String filename = "";
        if (cls.isAnnotationPresent(CsvEntity.class)) {
            CsvEntity csvEntity = (CsvEntity) cls.getDeclaredAnnotation(CsvEntity.class);
            separator = csvEntity.valuesSeparator();
            filename = csvEntity.filename();
        }

        for (Field field : cls.getDeclaredFields()) {
            for (Annotation annotation : field.getDeclaredAnnotations()) {
                if (annotation.annotationType().equals(CsvProperty.class)) {

                    CsvProperty csvProperty = (CsvProperty) annotation;
                    int col = csvProperty.columnNumber();
                    field.setAccessible(true);

                    if (csvProperty.propertyType().equals(CsvProperty.Type.SimpleProperty)) {
                        dataLine.put(col, String.valueOf(field.get(obj)));

                    } else {
                        if (field.get(obj) != null) {

                            Object subObj = field.get(obj);
                            Field subField = subObj.getClass().getDeclaredField(csvProperty.keyField());
                            subField.setAccessible(true);
                            dataLine.put(col, String.valueOf(subField.get(subObj)));

                            if (!isSubHeaderExists) {
                                makeHeader(subObj);
                                isSubHeaderExists = true;
                            }
                            writeObject(subObj);
                        } else {
                            dataLine.put(col, String.valueOf("null"));
                        }
                    }
                }
            }
        }
        write(filename, dataLine, separator);
    }

    LinkedList<Object> readList(Object obj) throws Exception {

        Class cls = obj.getClass();
        String separator = "";
        String filename = "";
        if (cls.isAnnotationPresent(CsvEntity.class)) {
            CsvEntity csvEntity = (CsvEntity) cls.getDeclaredAnnotation(CsvEntity.class);
            separator = csvEntity.valuesSeparator();
            filename = csvEntity.filename();
        }
        CsvWriterReader writerReader = new CsvWriterReader(filename);
        HashMap<Integer, String> hashMap = writerReader.read();
        LinkedList<Object> list = new LinkedList<>();

        int i = 1;

        while (i < hashMap.size()) {

            Object Object = getObject(obj, hashMap.get(i + 1), separator);
            System.out.println(Object.toString());
            list.add(Object);
            i++;
        }
        return list;
    }

    private Object getObject(Object obj, String str, String separator) throws Exception {
        Class cls = obj.getClass();

        for (Field field : cls.getDeclaredFields()) {
            for (Annotation annotation : field.getDeclaredAnnotations()) {
                if (annotation.annotationType().equals(CsvProperty.class)) {

                    CsvProperty csvProperty = (CsvProperty) annotation;
                    int col = csvProperty.columnNumber();
                    field.setAccessible(true);

                    if (csvProperty.propertyType().equals(CsvProperty.Type.SimpleProperty)) {
                        if (field.getType() == String.class) {
                            field.set(obj, String.valueOf(lineRipper(str, separator, col)));
                        } else if (field.getType() == boolean.class || field.getType() == Boolean.class) {
                            field.set(obj, Boolean.valueOf(lineRipper(str, separator, col)));
                        } else if (field.getType() == byte.class || field.getType() == Byte.class) {
                            field.set(obj, Byte.valueOf(lineRipper(str, separator, col)));
                        } else if (field.getType() == char.class || field.getType() == Character.class) {
                            field.set(obj, lineRipper(str, separator, col).charAt(0));
                        } else if (field.getType() == short.class || field.getType() == Short.class) {
                            field.set(obj, Short.valueOf(lineRipper(str, separator, col)));
                        } else if (field.getType() == int.class || field.getType() == Integer.class) {
                            field.set(obj, Integer.valueOf(lineRipper(str, separator, col)));
                        } else if (field.getType() == long.class || field.getType() == Long.class) {
                            field.set(obj, Long.valueOf(lineRipper(str, separator, col)));
                        } else if (field.getType() == float.class || field.getType() == Float.class) {
                            field.set(obj, Float.valueOf(lineRipper(str, separator, col)));
                        } else if (field.getType() == double.class || field.getType() == Double.class) {
                            field.set(obj, Double.valueOf(lineRipper(str, separator, col)));
                        } else {
                            field.set(obj, "unknown type");
                        }

                    } else {
                        if (!lineRipper(str, separator, col).equals("null")) {
                            Class subClass = field.getType();
                            Object subObject = subClass.newInstance();

                            Field subField = subClass.getDeclaredField(csvProperty.keyField());
                            subField.setAccessible(true);
                            subField.set(subObject, Integer.valueOf(lineRipper(str, separator, col)));

                            field.set(obj, subObject);
                        } else {
                            field.set(obj, null);
                        }
                    }
                }
            }
        }
        return obj;
    }

    private void makeHeader(Object obj) {

        Class cls = obj.getClass();
        HashMap<Integer, String> header = new HashMap<>();
        String line = "";
        String separator = "";
        String filename = "";

        if (cls.isAnnotationPresent(CsvEntity.class)) {
            CsvEntity csvEntity = (CsvEntity) cls.getDeclaredAnnotation(CsvEntity.class);
            separator = csvEntity.valuesSeparator();
            filename = csvEntity.filename();
        }

        for (Field field : cls.getDeclaredFields()) {
            for (Annotation annotation : field.getDeclaredAnnotations()) {
                if (annotation.annotationType().equals(CsvProperty.class)) {

                    CsvProperty csvProperty = (CsvProperty) annotation;
                    field.setAccessible(true);
                    int col = csvProperty.columnNumber();
                    String name = field.getName();

                    header.put(col, name);
                }
            }
        }

        for (int i = 0; i <= header.size() - 1; i++) {
            line += header.get(i) + separator;
        }
        CsvWriterReader writerReader = new CsvWriterReader(filename);
        writerReader.write(line.substring(0, line.length() - separator.length()));
    }

    private void write(String filename, HashMap<Integer, String> dataLine, String separator) {
        String line = "";

        for (int i = 0; i <= dataLine.size() - 1; i++) {

            line += dataLine.get(i) + separator;
        }

        CsvWriterReader writerReader = new CsvWriterReader(filename);
        writerReader.write(line.substring(0, line.length() - separator.length()));
        dataLine.clear();
    }

    private String lineRipper(String line, String separator, int col) {
        String[] dataArray = line.split(separator);
        return dataArray[col];
    }
}
