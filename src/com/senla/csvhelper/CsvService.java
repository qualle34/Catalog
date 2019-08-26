package com.senla.csvhelper;

import java.io.FileInputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class CsvService {

    private static Logger LOGGER;

    static {
        try (FileInputStream ins = new FileInputStream("logging.properties")) {
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(CsvWriterReader.class.getName());
        } catch (Exception ignore) {
            ignore.printStackTrace();
        }
    }

    public void write(List<Object> list) {
        ICsvProcessor processor = new CsvProcessor();
        for (Object obj : list) {
            try {
                processor.writeObject(obj);
            } catch (Exception e) {
                LOGGER.log(Level.WARNING, "Writing error: " + e.getMessage());
            }
        }
    }

    public List<Object> read(Class cls) {
        ICsvProcessor processor = new CsvProcessor();
        List<Object> list = null;
        try {
            list = processor.readList(cls);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Reading error: " + e.getMessage());
        }
        return list;
    }
}
