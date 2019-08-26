package com.senla.csvhelper;

import java.util.List;

public class CsvService {

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

    public List<Object> read(Class cls) {
        CsvProcessor processor = new CsvProcessor();
        List<Object> list = null;
        try {
            list = processor.readList(cls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
