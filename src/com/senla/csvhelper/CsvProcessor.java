package com.senla.csvhelper;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;

class CsvProcessor {

    void writeObject(Object obj) throws Exception {

        Class cls = obj.getClass();
        HashMap<Integer, String> dataLine = new HashMap<>();
        String separator = "";
        String filename = cls.getSimpleName() + ".csv";
        String directory = "";

        if (cls.isAnnotationPresent(CsvEntity.class)) {
            CsvEntity csvEntity = (CsvEntity) cls.getDeclaredAnnotation(CsvEntity.class);
            separator = csvEntity.valuesSeparator();
            directory = csvEntity.directoryName();
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

                            writeObject(subObj);
                        } else {
                            dataLine.put(col, String.valueOf("null"));
                        }
                    }
                }
            }
        }
        write(directory, filename, dataLine, makeHeader(obj) ,separator);
    }

    LinkedList<Object> readList(Class cls) throws Exception {

        String separator = "";
        String filename = cls.getSimpleName() + ".csv";
        String directory = "";

        if (cls.isAnnotationPresent(CsvEntity.class)) {
            CsvEntity csvEntity = (CsvEntity) cls.getDeclaredAnnotation(CsvEntity.class);
            separator = csvEntity.valuesSeparator();
            directory = csvEntity.directoryName();
        }
        CsvWriterReader writerReader = new CsvWriterReader(directory, filename);

        HashMap<Integer, String> hashMap = writerReader.read();
        LinkedList<Object> list = new LinkedList<>();

        int i = 1;

        while (i < hashMap.size()) {
            list.add(getObject(cls, hashMap.get(i + 1), separator));
            i++;
        }
        return list;
    }

    private Object getObject(Class cls, String str, String separator) throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        Object obj = cls.newInstance();

        for (Field field : cls.getDeclaredFields()) {
            for (Annotation annotation : field.getDeclaredAnnotations()) {
                if (annotation.annotationType().equals(CsvProperty.class)) {

                    CsvProperty csvProperty = (CsvProperty) annotation;
                    int col = csvProperty.columnNumber();
                    field.setAccessible(true);

                    if (csvProperty.propertyType().equals(CsvProperty.Type.SimpleProperty)) {

                        guessType(field, obj, lineRipper(str, separator, col));

                    } else {
                        if (!lineRipper(str, separator, col).equals("null")) {
                            Class subClass = field.getType();

                            Field subField = subClass.getDeclaredField(csvProperty.keyField());
                            Integer id = Integer.valueOf(lineRipper(str, separator, col));

                            field.set(obj, getObjById(subClass, subField, id));
                        } else {
                            field.set(obj, null);
                        }
                    }
                }
            }
        }
        return obj;
    }

    private void guessType(Field field, Object obj, String value) throws IllegalAccessException {
        field.setAccessible(true);

        if (field.getType() == String.class) {
            field.set(obj, value);
        } else if (field.getType() == boolean.class || field.getType() == Boolean.class) {
            field.set(obj, Boolean.valueOf(value));
        } else if (field.getType() == byte.class || field.getType() == Byte.class) {
            field.set(obj, Byte.valueOf(value));
        } else if (field.getType() == char.class || field.getType() == Character.class) {
            field.set(obj, value.charAt(0));
        } else if (field.getType() == short.class || field.getType() == Short.class) {
            field.set(obj, Short.valueOf(value));
        } else if (field.getType() == int.class || field.getType() == Integer.class) {
            field.set(obj, Integer.valueOf(value));
        } else if (field.getType() == long.class || field.getType() == Long.class) {
            field.set(obj, Long.valueOf(value));
        } else if (field.getType() == float.class || field.getType() == Float.class) {
            field.set(obj, Float.valueOf(value));
        } else if (field.getType() == double.class || field.getType() == Double.class) {
            field.set(obj, Double.valueOf(value));
        } else {
            field.set(obj, "unknown type");
        }
    }

    private Object getObjById(Class cls, Field field, Integer id) throws IllegalAccessException {
        LinkedList list = readSubList(cls);
        field.setAccessible(true);
        Object trueObject = null;

        for (Object obj : list) {
            if (id == field.get(obj)) {
                trueObject = obj;
                break;
            }
        }
        return trueObject;
    }

    private LinkedList<Object> readSubList(Class cls) {
        LinkedList<Object> list = null;
        try {
            list = readList(cls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private String makeHeader(Object obj) {
        Class cls = obj.getClass();
        HashMap<Integer, String> header = new HashMap<>();
        String line = "";
        String separator = "";

        if (cls.isAnnotationPresent(CsvEntity.class)) {
            CsvEntity csvEntity = (CsvEntity) cls.getDeclaredAnnotation(CsvEntity.class);
            separator = csvEntity.valuesSeparator();
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

        return line.substring(0, line.length() - separator.length());
    }

    private void write(String directory, String filename, HashMap<Integer, String> dataLine, String header, String separator) {
        String line = "";

        for (int i = 0; i <= dataLine.size() - 1; i++) {

            line += dataLine.get(i) + separator;
        }

        CsvWriterReader writerReader = new CsvWriterReader(directory, filename);
        writerReader.write(line.substring(0, line.length() - separator.length()), header);
        dataLine.clear();
    }

    private String lineRipper(String line, String separator, int col) {
        String[] dataArray = line.split(separator);
        return dataArray[col];
    }
}
