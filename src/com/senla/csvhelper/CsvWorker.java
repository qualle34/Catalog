package com.senla.csvhelper;

import java.util.LinkedList;
import java.util.List;

public class CsvWorker {


    public void write(List<Object> list) {
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
        int i = 1;
        do {
            try {
                System.out.println(processor.readObject(obj, i).toString());  //
                list.add(processor.readObject(obj, i));                       //
            } catch (Exception e) {
                e.printStackTrace();
            }
            i++;

        } while (i < 4); //
        return list;
    }

    public Object read(Object obj, int row) {
        CsvProcessor processor = new CsvProcessor();
        try {
            obj = processor.readObject(obj, row);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
