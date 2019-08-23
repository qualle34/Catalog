package com.senla.csvhelper;

import java.util.LinkedList;

public class CsvService {

    public void write(LinkedList<Object> list) {
        CsvProcessor processor = new CsvProcessor();

        for (Object obj : list) {
            try {
                processor.writeObject(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void write(Object obj) {
        CsvProcessor processor = new CsvProcessor();

        try {
            processor.writeObject(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public LinkedList<Object> read(Class cls) {
        CsvProcessor processor = new CsvProcessor();
        LinkedList<Object> list = null;
        try {
            list = processor.readList(cls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
