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

    public LinkedList<Object> read(Object obj) {
        CsvProcessor processor = new CsvProcessor();
        LinkedList<Object> list = new LinkedList<>();

            try {
              list = processor.readList(obj);

            } catch (Exception e) {
                e.printStackTrace();
            }

        return list;
    }
}
