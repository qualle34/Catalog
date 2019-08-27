package com.senla.csvhelper;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CsvService {

    private static Logger LOG = Logger.getLogger(CsvService.class.getName());


    public void write(List<Object> list) {
        IProcessor processor = new CsvProcessor();
        for (Object obj : list) {
            try {
                processor.write(obj);
            } catch (Exception e) {
                LOG.log(Level.WARNING, "Writing error: " + e.getMessage());
            }
        }
    }

    public List<Object> read(Class cls) {
        IProcessor processor = new CsvProcessor();
        List<Object> list = null;
        try {
            list = processor.read(cls);
        } catch (Exception e) {
            LOG.log(Level.WARNING, "Reading error: " + e.getMessage());
        }
        return list;
    }
}
